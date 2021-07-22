package kg.megacom.AddProject.models.objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.List;
@Data
public class InputData {

    private String text;
    private String name;
    private String email;
    private String phone;
//    private int lettersAmount;
    private List<ChenalDays> chenalDays;

}
