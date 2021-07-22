package kg.megacom.AddProject.service.impl;

import kg.megacom.AddProject.dao.OrderDaysRepo;
import kg.megacom.AddProject.mappers.OrderDaysMapper;
import kg.megacom.AddProject.models.OrderDays;
import kg.megacom.AddProject.models.dto.OrderDaysDto;
import kg.megacom.AddProject.models.dto.OrderDetailsDto;
import kg.megacom.AddProject.service.OrderDaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderDaysServiceImpl implements OrderDaysService {

    @Autowired
    private OrderDaysRepo orderDaysRepo;

    @Override
    public OrderDaysDto save(OrderDaysDto orderDaysDto) {
        OrderDays orderDays = OrderDaysMapper.INSTANCE.toOrderDays(orderDaysDto);
        orderDays = orderDaysRepo.save(orderDays);
        return OrderDaysMapper.INSTANCE.toOrderDaysDto(orderDays);
    }

    @Override
    public OrderDaysDto save1(Date date, OrderDetailsDto orderDetailsDto) {
        OrderDaysDto orderDaysDto = new OrderDaysDto();
        orderDaysDto.setDate(date);
        orderDaysDto.setOrderDetails(orderDetailsDto);
        OrderDays orderDays = orderDaysRepo.save(OrderDaysMapper.INSTANCE.toOrderDays(orderDaysDto));
        return OrderDaysMapper.INSTANCE.toOrderDaysDto(orderDays);
    }
}
