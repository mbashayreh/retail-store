package com.retail.store.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.ConfigurableEnvironment;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.Optional;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

@Configuration
@EnableSwagger2
@Scope(SCOPE_SINGLETON)
public class SwaggerConfig {

    @Bean
    public Docket apis(ConfigurableEnvironment environment) {
        return new Docket(DocumentationType.SWAGGER_2)
                .host(environment.getProperty("config.host"))
                .groupName(environment.getProperty("spring.application.name"))
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .genericModelSubstitutes(Optional.class)
                .select().apis(RequestHandlerSelectors.basePackage("com.retail.store.controller.rest"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfo(
                        "Retail client APIs Documentation",
                        "List of Retail client APIs Documentation",
                        "1.0.0", "https://google.ccm",
                        new Contact("converged-technology", "http://google.com",
                                "mosa_bashayreh@hotmail.com"),
                        "Retail API license 1.0",
                        "no url", Collections.emptyList()));
    }


}