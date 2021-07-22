//package kg.megacom.AddProject.controllers;
//
//import io.swagger.annotations.Api;
//import kg.megacom.AddProject.models.dto.OrderDetailsDto;
//import kg.megacom.AddProject.service.OrderDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//import static kg.megacom.AddProject.Configs.Swagger2Config.DISCOUNTS;
//import static kg.megacom.AddProject.Configs.Swagger2Config.ORDER_DATAILS;
//
//@Api(tags = ORDER_DATAILS)
//@RestController
//@RequestMapping(value = "/api/v1/order-details")
//public class OrderDetailsControllers {
//
//    @Autowired
//    private OrderDetailsService orderDetailsService;
//
//    @GetMapping("/all-order-details")
//    public List<OrderDetailsDto> findAll(){
//        return orderDetailsService.findAll();
//    }
//
//    @PostMapping("/save")
//    public OrderDetailsDto sava(@RequestBody OrderDetailsDto orderDetailsDto){
//        return orderDetailsService.save(orderDetailsDto);
//    }
//
//}
