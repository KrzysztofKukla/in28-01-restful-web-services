package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain.User;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain.UserRepository;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.mapper.UserMapper;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.model.UserDto;

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
public class UserBootstrap implements CommandLineRunner {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            createUsers();
        }
    }

    private void createUsers() {

//        User first = User.builder().birthDate(Timestamp.valueOf(LocalDateTime.now())).name("first").build();
//        User second = User.builder().birthDate(Timestamp.valueOf(LocalDateTime.now())).name("second").build();
//        User third = User.builder().birthDate(Timestamp.valueOf(LocalDateTime.now())).name("third").build();

        UserDto first = UserDto.builder().birthDate(OffsetDateTime.now()).name("first").build();
        UserDto second = UserDto.builder().birthDate(OffsetDateTime.now()).name("second").build();
        UserDto third = UserDto.builder().birthDate(OffsetDateTime.now()).name("third").build();

        List<UserDto> users = Arrays.asList(first, second, third);
        List<User> entityUsers = users.stream().map(userMapper::userDtoToUser).collect(Collectors.toList());
        userRepository.saveAll(entityUsers);
        log.debug("Users have been saved");

    }

}
