package com.example.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@ConditionalOnExpression(value = "${useSwagger:false}")
@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket get() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .build()
                .apiInfo(createApiInfo());
    }

    private ApiInfo createApiInfo() {
        return new ApiInfoBuilder()
                .title("Student API")
                .description("Student Service is a student management tool.")
                .version("1.0")
                .license("Student Technology - License")
                .licenseUrl("http://www.student.com")
                .contact(new Contact("Student Technology", "http://www.student.com", null))
                .build();
    }
}
