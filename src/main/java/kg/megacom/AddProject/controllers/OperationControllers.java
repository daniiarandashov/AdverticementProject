package kg.megacom.AddProject.controllers;

import io.swagger.annotations.Api;
import kg.megacom.AddProject.models.objects.FinalResponse;
import kg.megacom.AddProject.models.objects.InputData;
import kg.megacom.AddProject.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static kg.megacom.AddProject.Configs.Swagger2Config.OPERATION;

//В данном классе реализован метод по сохранению объекта InputData.Здесь мы принимаем основные данные которые приходя с фронтэнда.

@Api(tags = OPERATION)
@RestController
@RequestMapping(value = "/api/v1/operation")
public class OperationControllers {

    @Autowired
    private OperationService operationService;

    @PostMapping("/save")
    public FinalResponse save(@RequestBody InputData inputData) {
        return operationService.operation(inputData);
    }


}
