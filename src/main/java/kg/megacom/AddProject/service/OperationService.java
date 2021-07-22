package kg.megacom.AddProject.service;

import kg.megacom.AddProject.models.dto.OrderDaysDto;
import kg.megacom.AddProject.models.dto.OrderDto;
import kg.megacom.AddProject.models.objects.FinalResponse;
import kg.megacom.AddProject.models.objects.InputData;

import java.util.List;

public interface OperationService {

    FinalResponse operation(InputData inputData);


}
