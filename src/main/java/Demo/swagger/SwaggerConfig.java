package Demo.swagger;


import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {


//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//              //  .ApiInfo(metaInfo());
//    }


    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    private Predicate<String> postPaths() {
        return or(regex("/rest.*"), regex("/rest.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Swagger API")
                .description("Swagger API reference for developers")
                .termsOfServiceUrl("http://swagger.com")
                .contact("swagger@gmail.com").license("swagger License")
                .licenseUrl("swagger@gmail.com").version("1.0").build();
    }
}


//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.springboot.swaggerexample"))
//                .paths(regex("/rest.*"))
//                .build();
//               // .ApiInfo(apiInfo();
//    }
//    // Describe your apis
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Swagger Sample APIs")
//                .description("This page lists all the rest apis for Swagger Sample App.")
//                .version("1.0-SNAPSHOT")
//                .build();
//    }
//
//    // Only select apis that matches the given Predicates.
//    private Predicate<String> paths() {
//        // Match all paths except /error
//        return Predicates.and(
//                PathSelectors.regex("/.*"),
//                Predicates.not(PathSelectors.regex("/error.*"))
//        );

//    private ApiInfo metaInfo() {
//
//        ApiInfo apiInfo = new ApiInfo(
//                "Spring Boot Swagger Example API",
//                "Spring Boot Swagger Example API for Youtube",
//                "1.0",
//                "Terms of Service",
//                new Contact("TechPrimers", "https://www.youtube.com/watch?v=HHyjWc0ASl8",
//                        "sushil@gmail.com"),
//                "Apache License Version 2.0",
//                "https://www.apache.org/licesen.html"
//        );
//
//        return apiInfo;
//    }


