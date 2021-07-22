package kg.megacom.AddProject.service.impl;

import kg.megacom.AddProject.dao.OrderDetailsRepo;
import kg.megacom.AddProject.mappers.OrderDetailsMapper;
import kg.megacom.AddProject.mappers.OrderMapper;
import kg.megacom.AddProject.mappers.TvChanelMapper;
import kg.megacom.AddProject.models.OrderDetails;
import kg.megacom.AddProject.models.TvChanel;
import kg.megacom.AddProject.models.dto.OrderDaysDto;
import kg.megacom.AddProject.models.dto.OrderDetailsDto;
import kg.megacom.AddProject.models.dto.OrderDto;
import kg.megacom.AddProject.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Override
    public OrderDetailsDto save(OrderDetailsDto orderDetailsDto) {
        OrderDetails orderDetails = OrderDetailsMapper.INSTANCE.toOrderDetails(orderDetailsDto);
        orderDetails = orderDetailsRepo.save(orderDetails);
        return OrderDetailsMapper.INSTANCE.toOrderDetailsDto(orderDetails);
    }

    @Override
    public List<OrderDetailsDto> findAllByOrder(OrderDto orderDto) {
        List<OrderDetails> orderDetails = orderDetailsRepo.findAllByOrder(OrderMapper.INSTANCE.toOrder(orderDto));
        return OrderDetailsMapper.INSTANCE.toOrderDetailsDtoList(orderDetails);
    }

    @Override
    public List<OrderDetailsDto> findAll() {
        List<OrderDetails> orderDetailsList = orderDetailsRepo.findAll();
        return OrderDetailsMapper.INSTANCE.toOrderDetailsDtoList(orderDetailsList);

    }
}
