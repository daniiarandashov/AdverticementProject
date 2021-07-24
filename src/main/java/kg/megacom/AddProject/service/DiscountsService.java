package kg.megacom.AddProject.service;

import kg.megacom.AddProject.models.Discounts;
import kg.megacom.AddProject.models.dto.DiscountDto;

import java.util.List;

public interface DiscountsService {

    List<DiscountDto> findAll();

    DiscountDto save(DiscountDto discountDto);

    DiscountDto findByTvChannelAndMinDay(int days, Long id);

    DiscountDto findById(Long id);

    DiscountDto update(DiscountDto discountDto);

}
