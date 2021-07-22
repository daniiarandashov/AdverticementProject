package kg.megacom.AddProject.mappers;

import kg.megacom.AddProject.models.Clients;
import kg.megacom.AddProject.models.dto.ClientsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientsMapper {

    ClientsMapper INSTANCE = Mappers.getMapper(ClientsMapper.class);

    Clients toClients (ClientsDto clientsDto);
    ClientsDto toClientsDto (Clients clients);
    List<Clients> toClientsList(List<ClientsDto> clientsDtoList);
    List<ClientsDto> toClientsDtoList(List<Clients> clientsList);
}
