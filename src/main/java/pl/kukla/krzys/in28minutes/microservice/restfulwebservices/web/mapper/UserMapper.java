package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.mapper;

import org.mapstruct.Mapper;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain.User;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.model.UserDto;

/**
 * @author Krzysztof Kukla
 */
@Mapper(uses = DateMapper.class, componentModel = "spring")
public interface UserMapper {
    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

}
