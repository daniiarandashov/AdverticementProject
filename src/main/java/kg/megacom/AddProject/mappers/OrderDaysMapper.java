package kg.megacom.AddProject.mappers;

import kg.megacom.AddProject.models.OrderDays;
import kg.megacom.AddProject.models.dto.OrderDaysDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderDaysMapper {

    OrderDaysMapper INSTANCE = Mappers.getMapper(OrderDaysMapper.class);

    OrderDays toOrderDays(OrderDaysDto orderDaysDto);

    OrderDaysDto toOrderDaysDto(OrderDays orderDays);

    List<OrderDays> toOrderDaysList(List<OrderDaysDto> orderDaysDtoList);

    List<OrderDaysDto> toOrderDaysDtoList(List<OrderDays> orderDaysList);
}
