//package kg.megacom.AddProject.controllers;
//
//import io.swagger.annotations.Api;
//import kg.megacom.AddProject.models.dto.TvChanelDto;
//import kg.megacom.AddProject.service.FileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import static kg.megacom.AddProject.Configs.Swagger2Config.DISCOUNTS;
//import static kg.megacom.AddProject.Configs.Swagger2Config.FIlE;
//
//@Api(tags = FIlE)
//@RestController
//@RequestMapping(value = "/api/v1/file")
//public class FileControllers {
//
//    @Autowired
//    private FileService fileService;
//
//    @RequestMapping(value = "/logo", method =  RequestMethod.POST)
//    public TvChanelDto uploadLogo(@RequestParam Long tvChannelId, @RequestPart MultipartFile file){
//        return fileService.uploadLogo(tvChannelId, file);
//    }
//}