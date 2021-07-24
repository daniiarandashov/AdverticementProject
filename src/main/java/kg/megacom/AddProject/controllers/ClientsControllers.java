package kg.megacom.AddProject.controllers;

import io.swagger.annotations.Api;
import kg.megacom.AddProject.models.dto.ClientsDto;
import kg.megacom.AddProject.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static kg.megacom.AddProject.Configs.Swagger2Config.CLIENTS;

//В данном классе реализованны два метода:Post метод для сохранения клиента,Get метод для вывода всех клиентов

@Api(tags = CLIENTS)
@RestController
@RequestMapping(value = "/api/v1/clients")
public class ClientsControllers {

    @Autowired
    private ClientsService clientsService;

    @GetMapping("/all-clients")
    public List<ClientsDto> findAll() {
        return clientsService.findAll();
    }

    @PostMapping("/save")
    private ClientsDto save(@ModelAttribute ClientsDto clientsDto) {
        return clientsService.save(clientsDto);
    }
}
