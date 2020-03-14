package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * @author Krzysztof Kukla
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Name {

    private String firstName;
    private String lastName;

}
