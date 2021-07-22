//package kg.megacom.AddProject.controllers;
//
//import io.swagger.annotations.Api;
//import kg.megacom.AddProject.models.Order;
//import kg.megacom.AddProject.models.dto.OrderDto;
//import kg.megacom.AddProject.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//import static kg.megacom.AddProject.Configs.Swagger2Config.DISCOUNTS;
//import static kg.megacom.AddProject.Configs.Swagger2Config.ORDER;

//@Api(tags = ORDER)
//@RestController
//@RequestMapping(value = "/api/v1/orders")
//public class OrderControllers {
//
//    @Autowired
//    private OrderService orderService;
//
//    @GetMapping("/all-orders")
//    public List<OrderDto> findAll(){
//        return orderService.findAll();
//    }
//
//    @PostMapping("/save")
//    public OrderDto save(@RequestBody OrderDto orderDto){
//
//        return orderService.save(orderDto);
//    }
//}
