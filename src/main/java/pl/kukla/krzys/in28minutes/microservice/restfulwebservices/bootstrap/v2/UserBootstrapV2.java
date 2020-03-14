package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.bootstrap.v2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain.v2.Name;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain.v2.UserV2;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.repository.v2.UserRepositoryV2;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.mapper.v2.UserMapperV2;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.model.v2.UserDtoV2;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Krzysztof Kukla
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class UserBootstrapV2 implements CommandLineRunner {
    private final UserRepositoryV2 userRepository;
    private final UserMapperV2 userMapper;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            createUsers();
        }
    }

    private void createUsers() {

        Name name = Name.builder().firstName("dupa1").lastName("dupa2").build();

        UserDtoV2 first = UserDtoV2.builder().birthDate(OffsetDateTime.now()).name(name).password("pass1").build();
        UserDtoV2 second = UserDtoV2.builder().birthDate(OffsetDateTime.now()).name(name).password("pass2").build();
        UserDtoV2 third = UserDtoV2.builder().birthDate(OffsetDateTime.now()).name(name).password("pass3").build();

        List<UserDtoV2> usersDto = Arrays.asList(first, second, third);
        List<UserV2> entityUsers = usersDto.stream().map(userMapper::userDtoToUser).collect(Collectors.toList());
        userRepository.saveAll(entityUsers);
        log.debug("Users for version 2 have been saved");

    }

}
