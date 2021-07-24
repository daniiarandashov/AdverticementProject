package kg.megacom.AddProject.models.objects;

import lombok.Data;

import java.util.List;

//В данном классе создали переменные которые приходят с фронтэнда, которые в дальнейшем обрабатываются и сохраняются в БД

@Data
public class InputData {

    private String text;
    private String name;
    private String email;
    private String phone;
    private List<ChenalDays> chenalDays;

}
