package kg.megacom.AddProject.service;

import kg.megacom.AddProject.models.dto.PricesDto;

import java.util.List;

public interface PricesService {

    List<PricesDto> findAll();

    PricesDto save(PricesDto pricesDto);

    PricesDto findByChannelAndDate(Long channelId);

    PricesDto findById(Long id);

    PricesDto update (PricesDto pricesDto);
}
