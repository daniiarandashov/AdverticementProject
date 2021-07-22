package kg.megacom.AddProject.service;

import kg.megacom.AddProject.models.dto.OrderDetailsDto;
import kg.megacom.AddProject.models.dto.OrderDto;

import java.util.List;

public interface OrderDetailsService {

    OrderDetailsDto save(OrderDetailsDto orderDetailsDto);

    List<OrderDetailsDto> findAllByOrder(OrderDto orderDto);

    List<OrderDetailsDto> findAll();

}
