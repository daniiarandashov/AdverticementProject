package kg.megacom.AddProject.mappers;

import kg.megacom.AddProject.models.Prices;
import kg.megacom.AddProject.models.dto.PricesDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PricesMapper {

    PricesMapper INSTANCE = Mappers.getMapper(PricesMapper.class);

    Prices toPrices(PricesDto pricesDto);

    PricesDto toPricesDto(Prices prices);

    List<Prices> toPricesList(List<PricesDto> pricesDtoList);

    List<PricesDto> toPricesDtoList(List<Prices> pricesList);

}
