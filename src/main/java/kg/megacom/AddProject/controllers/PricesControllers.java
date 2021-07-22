package kg.megacom.AddProject.controllers;

import io.swagger.annotations.Api;
import kg.megacom.AddProject.models.dto.PricesDto;
import kg.megacom.AddProject.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static kg.megacom.AddProject.Configs.Swagger2Config.PRICES;

@Api(tags = PRICES)
@RestController
@RequestMapping(value = "/api/v1/prices")
public class PricesControllers {

    @Autowired
    private PricesService pricesService;

    @GetMapping("/all-prices")
    public List<PricesDto> showPrices(){
        return pricesService.findAll();
    }

    @PostMapping("/save")
    public PricesDto save(@RequestBody PricesDto pricesDto){
        return pricesService.save(pricesDto);
    }
    @PutMapping("/update")
    public PricesDto update(@RequestBody PricesDto pricesDto){
        return pricesService.update(pricesDto);
    }
}
