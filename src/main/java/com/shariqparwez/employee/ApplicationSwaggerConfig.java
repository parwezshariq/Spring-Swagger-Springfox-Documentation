package com.shariqparwez.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
@Import({SpringDataRestConfiguration.class, BeanValidatorPluginsConfiguration.class})
public class ApplicationSwaggerConfig {

    /*@Bean
    public Docket employeeApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                //.paths(PathSelectors.any())
                //.paths(PathSelectors.ant("/v1/**"))
                .paths(PathSelectors.ant("/v2/**"))
                .build()
                .apiInfo(getApiInfo());
    }

    // Create api metadata that goes at the top of the generated page
    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Employee API")
                //.version("1.0")
                .version("2.0")
                .description("API for managing employees.")
                .contact(new Contact("Shariq Parwez", "https://github.com/parwezshariq", "shariqparwez@outlook.com"))
                .license("Apache License Version 2.0")
                .build();
    }*/

    @Bean
    public Docket employeeApiOne() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("employee-api-v1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.shariqparwez.employee"))
                .paths(PathSelectors.ant("/employeev1/**"))
                .build()
                .apiInfo(getApiInfo("v1"));
    }

    @Bean
    public Docket employeeApiTwo() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("employee-api-v2")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.shariqparwez.employee"))
                .paths(PathSelectors.ant("/employeev2/**"))
                .build()
                .apiInfo(getApiInfo("v2"));
    }

    @Bean
    public Docket employeeApiThree() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("employee-api-v3")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.shariqparwez.employee"))
                .paths(PathSelectors.ant("/employeev3/**"))
                .build()
                .apiInfo(getApiInfo("v3"));
    }

    // Create api metadata that goes at the top of the generated page
    private ApiInfo getApiInfo(String version) {
        return new ApiInfoBuilder()
                .title("Employee API")
                .version(version)
                .description("API for managing employees.")
                .contact(new Contact("Shariq Parwez", "https://github.com/parwezshariq", "shariqparwez@outlook.com"))
                .license("Apache License Version 2.0")
                .build();
    }

}
