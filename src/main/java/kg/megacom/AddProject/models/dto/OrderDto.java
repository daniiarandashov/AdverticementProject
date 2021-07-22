package kg.megacom.AddProject.models.dto;

import lombok.Data;


@Data
public class OrderDto {

    private Long id;

    private String text;

    private int amount;

    private String code;

    private boolean paymentStatus;

    private ClientsDto clients;
}
