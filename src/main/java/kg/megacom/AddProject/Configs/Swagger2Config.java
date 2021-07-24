package kg.megacom.AddProject.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Настройки Swagger
@Configuration
@EnableSwagger2
public class Swagger2Config {

    public static final String CLIENTS = "Клиенты";
    public static final String DISCOUNTS = "Скидки";
    public static final String OPERATION = "Операции";
    public static final String PRICES = "Цены за символ";
    public static final String TV_CHANEL = "Каналы";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiEndPointsInfo())
                .tags(new Tag(CLIENTS, ""))
                .tags(new Tag(DISCOUNTS, ""))
                .tags(new Tag(OPERATION, ""))
                .tags(new Tag(PRICES, ""))
                .tags(new Tag(TV_CHANEL, ""));
    }
    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Adverticement Project")
                .description("Implementation of backend part of adverticement website")
                .version("1.0.0")
                .contact(new Contact("Daniiar Andashov", "http://www.megacom.kg", "daniiarandashov@gmail.com"))
                .build();
    }

}

