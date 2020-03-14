package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.service.v2;

import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.model.v2.UserDtoV2;

import java.util.List;

/**
 * @author Krzysztof Kukla
 */
public interface UserServiceV2 {

    List<UserDtoV2> getAll();

}
