package kg.megacom.AddProject.service.impl;

import kg.megacom.AddProject.microservice.FileServiceFeign;
import kg.megacom.AddProject.microservice.object.Response;
import kg.megacom.AddProject.models.dto.TvChanelDto;
import kg.megacom.AddProject.service.FileService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileServiceFeign fileServiceFeign;
    @Autowired
    private TvChanelServiceImpl tvChanelService;

    @Override
    public TvChanelDto uploadLogo(Long id, MultipartFile file) {
        TvChanelDto tvChanelDto = tvChanelService.findById(id);

        Response response = fileServiceFeign.upload(file);

        tvChanelDto.setLogo((response.getDownloadUri()));

        tvChanelDto = tvChanelService.update(tvChanelDto);

        return tvChanelDto;
    }
}
