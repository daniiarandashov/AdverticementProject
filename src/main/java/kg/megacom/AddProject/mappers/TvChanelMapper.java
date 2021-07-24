package kg.megacom.AddProject.mappers;

import kg.megacom.AddProject.models.TvChanel;
import kg.megacom.AddProject.models.dto.TvChanelDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
public interface TvChanelMapper {

    TvChanelMapper INSTANCE = Mappers.getMapper(TvChanelMapper.class);

    TvChanel toTvChanel(TvChanelDto tvChanelDto);

    TvChanelDto toTvChanelDto(TvChanel tvChanel);

    List<TvChanel> toTvChanelList(List<TvChanelDto> tvChanelDtoList);

    List<TvChanelDto> toTvChanelDtoList(List<TvChanel> tvChanelList);
}
