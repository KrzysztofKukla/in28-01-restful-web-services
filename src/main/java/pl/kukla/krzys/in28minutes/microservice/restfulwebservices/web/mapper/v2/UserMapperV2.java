package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.mapper.v2;

import org.mapstruct.Mapper;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain.v2.UserV2;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.mapper.DateMapper;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.model.v2.UserDtoV2;

/**
 * @author Krzysztof Kukla
 */
@Mapper(uses = DateMapper.class, componentModel = "spring")
public interface UserMapperV2 {
    UserDtoV2 userToUserDto(UserV2 user);

    UserV2 userDtoToUser(UserDtoV2 userDto);

}
