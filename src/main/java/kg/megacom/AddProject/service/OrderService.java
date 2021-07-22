package kg.megacom.AddProject.service;

import kg.megacom.AddProject.models.dto.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> findAll();

    OrderDto save (OrderDto orderDto);

    OrderDto findById (Long id);

    OrderDto update (OrderDto orderDto);
}
