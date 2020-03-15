package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain.User;

import java.util.UUID;

/**
 * @author Krzysztof Kukla
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {

    private UUID id;

    private String description;

    private User user;

}
