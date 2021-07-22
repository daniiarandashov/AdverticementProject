package kg.megacom.AddProject.service.impl;

import kg.megacom.AddProject.dao.PricesRepo;
import kg.megacom.AddProject.mappers.PricesMapper;
import kg.megacom.AddProject.models.Prices;
import kg.megacom.AddProject.models.dto.PricesDto;
import kg.megacom.AddProject.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class PricesServiceImpl implements PricesService {

    @Autowired
    private PricesRepo pricesRepo;

    @Override
    public List<PricesDto> findAll() {
        List<Prices> pricesList = pricesRepo.findAll();
        return PricesMapper.INSTANCE.toPricesDtoList(pricesList);
    }

    @Override
    public PricesDto save(PricesDto pricesDto) {
        Prices prices = PricesMapper.INSTANCE.toPrices(pricesDto);
        prices = pricesRepo.save(prices);
        return PricesMapper.INSTANCE.toPricesDto(prices);
    }

    @Override
    public PricesDto findByChannelAndDate(Long channelId) {
        Prices prices = pricesRepo.findByChannelAndDate(channelId);
        return PricesMapper.INSTANCE.toPricesDto(prices);
    }

    @Override
    public PricesDto findById(Long id) {
        return null;
    }

    @Override
    public PricesDto update(PricesDto pricesDto) {
        Prices prices = pricesRepo.findById(pricesDto.getId()).orElse(null);
        PricesDto pricesDto1 = PricesMapper.INSTANCE.toPricesDto(prices);
        pricesDto1.setPrice(pricesDto.getPrice());
        pricesDto1.setEnd_date(pricesDto.getEnd_date());
        pricesDto1.setStart_date(pricesDto.getStart_date());
        if(prices == null){
            throw new RuntimeException("Not found");
        }
        prices = pricesRepo.save(PricesMapper.INSTANCE.toPrices(pricesDto1));
        return PricesMapper.INSTANCE.toPricesDto(prices);
    }
}
