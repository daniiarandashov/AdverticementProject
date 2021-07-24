package kg.megacom.AddProject.mappers;

import kg.megacom.AddProject.models.Order;
import kg.megacom.AddProject.models.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toOrder(OrderDto orderDto);

    OrderDto toOrderDto(Order order);

    List<Order> toOrderList(List<OrderDto> orderDtoList);

    List<OrderDto> toOrderDtoList(List<Order> orderList);
}
