package kg.megacom.AddProject.models.objects;

import jdk.dynalink.linker.LinkerServices;
import kg.megacom.AddProject.models.dto.TvChanelDto;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class ChenalDays {

    private TvChanelDto chanelDto;
    private List<Date> days;
}
