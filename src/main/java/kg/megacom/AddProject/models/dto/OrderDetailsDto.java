package kg.megacom.AddProject.models.dto;

import lombok.Data;

@Data
public class OrderDetailsDto {

    private Long id;
    private double price;
    private OrderDto order;
    private TvChanelDto tvChanel;

}
