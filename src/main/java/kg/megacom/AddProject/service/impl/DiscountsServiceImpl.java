package kg.megacom.AddProject.service.impl;

import kg.megacom.AddProject.dao.DiscountsRepo;
import kg.megacom.AddProject.mappers.DiscountMapper;
import kg.megacom.AddProject.mappers.PricesMapper;
import kg.megacom.AddProject.models.Discounts;
import kg.megacom.AddProject.models.Prices;
import kg.megacom.AddProject.models.dto.DiscountDto;
import kg.megacom.AddProject.models.dto.PricesDto;
import kg.megacom.AddProject.service.DiscountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiscountsServiceImpl implements DiscountsService {

    @Autowired
    private DiscountsRepo discountsRepo;

    @Override
    public List<DiscountDto> findAll() {
        List<Discounts> discountsList = discountsRepo.findAll();
        return DiscountMapper.INSTANCE.toDiscountDtoList(discountsList);
    }

    @Override
    public DiscountDto save(DiscountDto discountDto) {
        Discounts discounts = DiscountMapper.INSTANCE.toDiscount(discountDto);
        discounts = discountsRepo.save(discounts);
        return DiscountMapper.INSTANCE.toDiscountDto(discounts);
    }

    @Override
    public DiscountDto findByTvChannelAndMinDay(int days, Long id) {
        Discounts discounts = discountsRepo.findByTvChannelAndMinDay(days, id);
        return DiscountMapper.INSTANCE.toDiscountDto(discounts);
    }

    @Override
    public DiscountDto findById(Long id) {
        return null;
    }

    @Override
    public DiscountDto update(DiscountDto discountDto) {
        Discounts discounts = discountsRepo.findById(discountDto.getId()).orElse(null);
        DiscountDto discountDto1 = DiscountMapper.INSTANCE.toDiscountDto(discounts);
        discountDto1.setDiscount(discountDto.getDiscount());
        discountDto1.setEnd_date(discountDto.getEnd_date());
        discountDto1.setStart_date(discountDto.getStart_date());
        if(discounts == null){
            throw new RuntimeException("Not found");
        }
        discounts = discountsRepo.save(DiscountMapper.INSTANCE.toDiscount(discountDto1));
        return DiscountMapper.INSTANCE.toDiscountDto(discounts);
    }
}
