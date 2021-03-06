package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain.User;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.exception.UserNotFoundException;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.repository.UserRepository;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.mapper.UserMapper;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.model.UserDto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Krzysztof Kukla
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto getById(UUID id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id.toString()));
        return userMapper.userToUserDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        List<UserDto> users = userRepository.findAll().stream()
            .map(user -> userMapper.userToUserDto(user)).collect(Collectors.toList());
        return users;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User savedUser = userRepository.save(userMapper.userDtoToUser(userDto));
        log.debug("user has been saved");
        return userMapper.userToUserDto(savedUser);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(UUID.fromString(id));
        log.debug("User has been deleted");
    }

}
