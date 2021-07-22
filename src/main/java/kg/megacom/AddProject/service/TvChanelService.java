package kg.megacom.AddProject.service;

import kg.megacom.AddProject.models.dto.TvChanelDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TvChanelService {

    List<TvChanelDto> findAll();

    TvChanelDto save(TvChanelDto tvChanelDto, MultipartFile file);

    TvChanelDto findById(Long id);

    TvChanelDto update(TvChanelDto tvChanelDto);

    TvChanelDto deactivate(Long id);

    List<TvChanelDto> findActiveChannels();
}
