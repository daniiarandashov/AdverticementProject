package kg.megacom.AddProject.service;


import kg.megacom.AddProject.models.Clients;
import kg.megacom.AddProject.models.dto.ClientsDto;

import java.util.List;

public interface ClientsService {

    List<ClientsDto> findAll();

    ClientsDto save(ClientsDto clientsDto);

    ClientsDto findById(Long id);

    ClientsDto findByPhone(String phone);

    ClientsDto update(ClientsDto clientsDto);
}
