package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.service.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain.v2.UserV2;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.repository.v2.UserRepositoryV2;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.mapper.v2.UserMapperV2;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.model.v2.UserDtoV2;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Krzysztof Kukla
 */
@Service
@RequiredArgsConstructor
public class UserServiceImplV2 implements UserServiceV2 {

    private final UserRepositoryV2 userRepositoryV2;
    private final UserMapperV2 userMapperV2;

    @Override
    public List<UserDtoV2> getAll() {
        List<UserV2> users = userRepositoryV2.findAll();
        List<UserDtoV2> userDtoV2s = users.stream().map(userMapperV2::userToUserDto).collect(Collectors.toList());
        return userDtoV2s;
    }

}
