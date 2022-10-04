package com.altice.alticcisequence.openapi;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig implements WebMvcConfigurer {

	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.altice.alticcisequence.controller")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo()).tags(new Tag("Sequence value", "Manage Alticci sequence values."));
	}

	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Alticci Sequence API").description("API for Altice Labs").version("1")
				.build();
	}
}
