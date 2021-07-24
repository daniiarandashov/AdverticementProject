package kg.megacom.AddProject.mappers;

import kg.megacom.AddProject.models.OrderDetails;
import kg.megacom.AddProject.models.dto.OrderDetailsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderDetailsMapper {

    OrderDetailsMapper INSTANCE = Mappers.getMapper(OrderDetailsMapper.class);

    OrderDetails toOrderDetails(OrderDetailsDto orderDetailsDto);

    OrderDetailsDto toOrderDetailsDto(OrderDetails orderDetails);

    List<OrderDetails> toOrderDetailsList(List<OrderDetailsDto> orderDetailsDtoList);

    List<OrderDetailsDto> toOrderDetailsDtoList(List<OrderDetails> orderDetailsList);

}
