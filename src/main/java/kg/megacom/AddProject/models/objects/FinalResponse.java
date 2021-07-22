package kg.megacom.AddProject.models.objects;

import lombok.Data;

@Data
public class FinalResponse {

    private int status;
    private String message;
    private String adText;
    private double totalSum;
}
