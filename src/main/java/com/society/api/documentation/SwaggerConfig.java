package com.society.api.documentation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.society.api.controller")).build().apiInfo(metaInfo());

	}

	private ApiInfo metaInfo() {
		return new ApiInfoBuilder().title("API endpoints available").version("1.0-SNAPSHOT").build();

	}

	// Only select apis that matches the given Predicates.
	private Predicate<String> paths() {
		// Match all paths except / ie index controller and error
		return Predicates.and(PathSelectors.regex("/api.*"), Predicates.not(PathSelectors.regex("/error.*")));
	}
}