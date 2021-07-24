package kg.megacom.AddProject.controllers;

import io.swagger.annotations.Api;
import kg.megacom.AddProject.models.dto.DiscountDto;
import kg.megacom.AddProject.service.DiscountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static kg.megacom.AddProject.Configs.Swagger2Config.DISCOUNTS;

//В данном классе реализованно три метода по сохранению,обнавлению и вывода объекта Discount

@Api(tags = DISCOUNTS)
@RestController
@RequestMapping(value = "/api/v1/discounts")
public class DiscountControllers {
    @Autowired
    private DiscountsService discountsService;

    @GetMapping("/all-discounts")
    public List<DiscountDto> findAll() {
        return discountsService.findAll();
    }

    @PostMapping("/save")
    public DiscountDto save(@RequestBody DiscountDto discountDto) {
        return discountsService.save(discountDto);
    }

    @PutMapping("/update")
    public DiscountDto update(@RequestBody DiscountDto discountDto) {
        return discountsService.update(discountDto);
    }
}
