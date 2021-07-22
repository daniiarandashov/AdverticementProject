package kg.megacom.AddProject.service.impl;

import kg.megacom.AddProject.models.dto.*;
import kg.megacom.AddProject.models.objects.ChenalDays;
import kg.megacom.AddProject.models.objects.FinalResponse;
import kg.megacom.AddProject.models.objects.InputData;
import kg.megacom.AddProject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private ClientsService clientsService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailsService orderDetailsService;
    @Autowired
    private DiscountsService discountsService;
    @Autowired
    private PricesService pricesService;
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private OrderDaysService orderDaysService;


    @Override
    public FinalResponse operation(InputData inputData) {

        FinalResponse finalResponse = new FinalResponse();

        ClientsDto clientsDto = clientsService.findByPhone(inputData.getPhone());
        if (clientsDto == null) {
            clientsDto = new ClientsDto();
            clientsDto.setEmail(inputData.getEmail());
            clientsDto.setName(inputData.getName());
            clientsDto.setPhone(inputData.getPhone());
            clientsDto = clientsService.save(clientsDto);
        }

        OrderDto orderDto = new OrderDto();
        String textLength = inputData.getText().replaceAll("\\s+", "");
        orderDto.setAmount(textLength.length());
        orderDto.setClients(clientsDto);
        orderDto.setPaymentStatus(false);
        orderDto.setText(inputData.getText());
        OrderDto orderDto1 = orderService.save(orderDto);

        double totalSum;

        List<ChenalDays> chenalDays = inputData.getChenalDays();
        chenalDays.stream()
                .forEach(x -> {
                    OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
                    orderDetailsDto.setOrder(orderDto1);
                    orderDetailsDto.setTvChanel(x.getChanelDto());

                    int days = x.getDays().size();

                    DiscountDto discountDto = discountsService.findByTvChannelAndMinDay(days, x.getChanelDto().getId());
                    Long tvChanelId = x.getChanelDto().getId();
                    PricesDto pricesDto = pricesService.findByChannelAndDate(tvChanelId);
                    double pricePerSymbol = pricesDto.getPrice();
                    int symbolAmount = orderDto.getAmount();

                    OrderDetailsDto orderDetailsDto1;
                    if (discountDto != null) {
                        int percent = discountDto.getDiscount();

                        double withoutDiscount = symbolAmount * pricePerSymbol;
                        double discountInSum = withoutDiscount * percent / 100;
                        double sumForChanel = (withoutDiscount - discountInSum) * days;
                        orderDetailsDto.setPrice(sumForChanel);
                        orderDetailsDto1 = orderDetailsService.save(orderDetailsDto);
                    } else {
                        double withoutDiscount = (symbolAmount * pricePerSymbol) * days;
                        orderDetailsDto.setPrice(withoutDiscount);
                        orderDetailsDto1 = orderDetailsService.save(orderDetailsDto);
                    }

                    List<Date> date = x.getDays();
                    date.stream().forEach(d -> {
                        orderDaysService.save1(d, orderDetailsDto1);
                    });
                });

        List<OrderDetailsDto> orderDetailsDtoList = orderDetailsService.findAllByOrder(orderDto1);
        totalSum = orderDetailsDtoList.stream().mapToDouble(x -> x.getPrice()).sum();

        String code = generateCode();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("daniiarandashov@gmail.com");
        message.setTo(inputData.getEmail());
        message.setSubject("Оповещение!");
        message.setText("Приветствуем " + inputData.getName() + "!!!" + "\nТекст вашего объявления : " + inputData.getText() + "\nСумма к оплате : " + totalSum + "сом" + "\nВаш код оплаты : " + code);
        emailSender.send(message);

        orderDto1.setCode(code);
        orderDto1.setPaymentStatus(true);
        orderService.update(orderDto1);

        finalResponse.setMessage("Успешно соханено");
        finalResponse.setStatus(1);
        finalResponse.setAdText(inputData.getText());
        finalResponse.setTotalSum(totalSum);

        return finalResponse;
    }

    public String generateCode() {
        int randomPIN = (int) (Math.random() * 9000) + 1000;
        String val = "" + randomPIN;
        return val;
    }
}
