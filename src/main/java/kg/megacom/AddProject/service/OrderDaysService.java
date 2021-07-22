package kg.megacom.AddProject.service;

import kg.megacom.AddProject.models.dto.OrderDaysDto;
import kg.megacom.AddProject.models.dto.OrderDetailsDto;

import java.util.Date;


public interface OrderDaysService {
    OrderDaysDto save(OrderDaysDto orderDaysDto);

    OrderDaysDto save1(Date date, OrderDetailsDto orderDetailsDto);


}
