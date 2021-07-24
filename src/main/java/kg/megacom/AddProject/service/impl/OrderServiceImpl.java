package kg.megacom.AddProject.service.impl;

import kg.megacom.AddProject.dao.OrderRepo;
import kg.megacom.AddProject.mappers.OrderMapper;
import kg.megacom.AddProject.models.Order;
import kg.megacom.AddProject.models.dto.OrderDto;
import kg.megacom.AddProject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Override
    public List<OrderDto> findAll() {
        List<Order> orderList = orderRepo.findAll();
        return OrderMapper.INSTANCE.toOrderDtoList(orderList);
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
        Order order = OrderMapper.INSTANCE.toOrder(orderDto);
        int length = order.getText().length();
        order.setAmount(length);
        order = orderRepo.save(order);
        return OrderMapper.INSTANCE.toOrderDto(order);
    }

    @Override
    public OrderDto findById(Long id) {
        return null;
    }

    @Override
    public OrderDto update(OrderDto orderDto) {
        Order order = orderRepo.findById(orderDto.getId()).orElse(null);
        if (order == null) {
            throw new RuntimeException("Not found");
        }
        order = OrderMapper.INSTANCE.toOrder(orderDto);
        order = orderRepo.save(order);
        return OrderMapper.INSTANCE.toOrderDto(order);
    }
}
