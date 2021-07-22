//package kg.megacom.AddProject.controllers;
//
//import io.swagger.annotations.Api;
//import kg.megacom.AddProject.models.dto.OrderDaysDto;
//import kg.megacom.AddProject.service.OrderDaysService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import static kg.megacom.AddProject.Configs.Swagger2Config.DISCOUNTS;
//import static kg.megacom.AddProject.Configs.Swagger2Config.ORDER_DAYS;
//
//@Api(tags = ORDER_DAYS)
//@RestController
//@RequestMapping(value = "/api/v1/order-days")
//public class OrderDaysControllers {
//
//    @Autowired
//    private OrderDaysService orderDaysService;
//
//    @PostMapping("/save")
//    public OrderDaysDto save(@RequestBody OrderDaysDto orderDaysDto){
//        return orderDaysService.save(orderDaysDto);
//    }
//}
