package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.service;

import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.model.UserDto;

import java.util.List;
import java.util.UUID;

/**
 * @author Krzysztof Kukla
 */
public interface UserService {
    UserDto getById(UUID id);

    List<UserDto> getAll();

    UserDto createUser(UserDto userDto);

}
