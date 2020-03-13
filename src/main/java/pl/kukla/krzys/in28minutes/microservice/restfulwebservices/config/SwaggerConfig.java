package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Krzysztof Kukla
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Contact DEFAULT_CONTACT = new Contact("Krzysztof Kukla", "http://www", "krzys.kukla@gmail.com");
    private static final ApiInfo DEFAULT = new ApiInfo("Api Dupa Documentation", "Api Documentation", "1.0", "urn:tos",
        DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMERS = new HashSet<>(
        Arrays.asList("application/json", "application/xml")
    );

    //it allows to generate swagger endpoints
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(DEFAULT)
            .produces(DEFAULT_PRODUCES_AND_CONSUMERS)
            .consumes(DEFAULT_PRODUCES_AND_CONSUMERS);
    }

}
