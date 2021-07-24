package kg.megacom.AddProject.models.objects;

import kg.megacom.AddProject.models.dto.TvChanelDto;
import lombok.Data;

import java.util.Date;
import java.util.List;

//В данном классе создали переменные которые приходят с фронтэнда, которые в дальнейшем обрабатываются и сохраняются в БД

@Data
public class ChenalDays {

    private TvChanelDto chanelDto;
    private List<Date> days;
}
