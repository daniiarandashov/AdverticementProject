package kg.megacom.AddProject.service.impl;

import kg.megacom.AddProject.dao.TvChanelRepo;
import kg.megacom.AddProject.mappers.TvChanelMapper;
import kg.megacom.AddProject.microservice.FileServiceFeign;
import kg.megacom.AddProject.microservice.object.Response;
import kg.megacom.AddProject.models.TvChanel;
import kg.megacom.AddProject.models.dto.TvChanelDto;
import kg.megacom.AddProject.service.TvChanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class TvChanelServiceImpl implements TvChanelService {

    @Autowired
    private TvChanelRepo tvChanelRepo;
    @Autowired
    private FileServiceFeign fileServiceFeign;

    @Override
    public List<TvChanelDto> findAll() {
        List<TvChanel> tvChanelList = tvChanelRepo.findAll();
        return TvChanelMapper.INSTANCE.toTvChanelDtoList(tvChanelList);
    }


    @Override
    public TvChanelDto save(TvChanelDto tvChanelDto, MultipartFile file) {
        Response response = fileServiceFeign.upload(file);
        tvChanelDto.set_active(true);
        tvChanelDto.setLogo((response.getDownloadUri()));
        TvChanel tvChanel = TvChanelMapper.INSTANCE.toTvChanel(tvChanelDto);
        tvChanel = tvChanelRepo.save(tvChanel);
        return TvChanelMapper.INSTANCE.toTvChanelDto(tvChanel);
    }

    @Override
    public TvChanelDto findById(Long id) {
        TvChanel tvChanel = tvChanelRepo.findById(id).orElse(null);
        if (tvChanel == null) {
            throw new RuntimeException("Not found");
        }
        return TvChanelMapper.INSTANCE.toTvChanelDto(tvChanel);
    }

    @Override
    public TvChanelDto update(TvChanelDto tvChanelDto) { // 1
        TvChanel tvChanel = tvChanelRepo.findById(tvChanelDto.getId()).orElse(null);
        if (tvChanel == null) {
            throw new RuntimeException("Not found");
        }
        tvChanel.setLogo(tvChanelDto.getLogo());
        tvChanel = tvChanelRepo.save(tvChanel);
        return TvChanelMapper.INSTANCE.toTvChanelDto(tvChanel);
    }

    @Override
    public TvChanelDto deactivate(Long id) {
        TvChanel tvChanel = tvChanelRepo.findById(id).orElse(null);
        if (tvChanel == null) {
            throw new RuntimeException("Not found");
        }
        TvChanelDto tvChanelDto = TvChanelMapper.INSTANCE.toTvChanelDto(tvChanel);
        tvChanelDto.set_active(false);
        tvChanel = tvChanelRepo.save(TvChanelMapper.INSTANCE.toTvChanel(tvChanelDto));
        return TvChanelMapper.INSTANCE.toTvChanelDto(tvChanel);
    }

    @Override
    public List<TvChanelDto> findActiveChannels() {
        return TvChanelMapper.INSTANCE.toTvChanelDtoList(tvChanelRepo.findByIs_activeTrue());
    }


}
