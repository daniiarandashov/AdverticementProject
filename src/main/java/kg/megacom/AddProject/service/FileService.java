package kg.megacom.AddProject.service;

import kg.megacom.AddProject.models.dto.TvChanelDto;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    TvChanelDto uploadLogo(Long id, MultipartFile file);
}
