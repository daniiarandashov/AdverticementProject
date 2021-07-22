package kg.megacom.AddProject.service.impl;

import kg.megacom.AddProject.dao.ClientsRepo;
import kg.megacom.AddProject.mappers.ClientsMapper;
import kg.megacom.AddProject.models.Clients;
import kg.megacom.AddProject.models.dto.ClientsDto;
import kg.megacom.AddProject.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    private ClientsRepo clientsRepo;

    @Override
    public List<ClientsDto> findAll() {
        List<Clients> clientsList = clientsRepo.findAll();
        return ClientsMapper.INSTANCE.toClientsDtoList(clientsList);
    }

    @Override
    public ClientsDto save(ClientsDto clientsDto) {
        Clients clients = ClientsMapper.INSTANCE.toClients(clientsDto);
        clients = clientsRepo.save(clients);
        return ClientsMapper.INSTANCE.toClientsDto(clients);
    }

    @Override
    public ClientsDto findById(Long id) {
        return null;
    }

    @Override
    public ClientsDto findByPhone(String phone) {
        Clients clients = clientsRepo.findByPhone(phone);
        return ClientsMapper.INSTANCE.toClientsDto(clients);
    }

    @Override
    public ClientsDto update(ClientsDto clientsDto) {
        return null;
    }
}
