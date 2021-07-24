package kg.megacom.AddProject.models.objects;

import lombok.Data;

//В данном классе создаются переменные которые формирют Response

@Data
public class FinalResponse {

    private int status;
    private String message;
    private String adText;
    private double totalSum;
}
