package kg.megacom.AddProject.controllers;


import io.swagger.annotations.Api;
import kg.megacom.AddProject.models.dto.TvChanelDto;
import kg.megacom.AddProject.service.TvChanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static kg.megacom.AddProject.Configs.Swagger2Config.DISCOUNTS;
import static kg.megacom.AddProject.Configs.Swagger2Config.TV_CHANEL;

@Api(tags = TV_CHANEL)
@RestController
@RequestMapping(value = "/api/v1/chanels")
public class TvChanelControllers {

    @Autowired
    private TvChanelService tvChanelService;


    @GetMapping("/all-chanels")
    public List<TvChanelDto> showTvChanel() {
        return tvChanelService.findAll();
    }

    @PostMapping("/save")
    public TvChanelDto save(@ModelAttribute TvChanelDto tvChanelDto, @RequestPart MultipartFile file){
        return tvChanelService.save(tvChanelDto,file);
    }

    @GetMapping("/find-by-id")
    public TvChanelDto findById(Long id){
        return tvChanelService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public TvChanelDto deactivateChannel(@PathVariable Long id){
        return tvChanelService.deactivate(id);
    }

    @GetMapping("/active-channels")
    public List<TvChanelDto> selectAllActiveChannels(){
        return tvChanelService.findActiveChannels();
    }

}
