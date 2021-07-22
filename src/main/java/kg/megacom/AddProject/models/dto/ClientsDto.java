package kg.megacom.AddProject.models.dto;

import lombok.Data;

import javax.persistence.Column;
@Data
public class ClientsDto {

    private Long id;
    private String name;
    private String phone;
    private String email;

}
