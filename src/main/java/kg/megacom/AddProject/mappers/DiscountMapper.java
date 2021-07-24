package kg.megacom.AddProject.mappers;

import kg.megacom.AddProject.models.Discounts;
import kg.megacom.AddProject.models.dto.DiscountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DiscountMapper {

    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);

    Discounts toDiscount(DiscountDto discountDto);

    DiscountDto toDiscountDto(Discounts discounts);

    List<Discounts> toDiscountList(List<DiscountDto> discountDtoList);

    List<DiscountDto> toDiscountDtoList(List<Discounts> discountsList);
}
