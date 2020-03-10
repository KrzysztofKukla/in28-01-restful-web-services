package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.service.UserService;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.model.UserDto;

import java.net.URI;
import java.util.List;
import java.util.UUID;

/**
 * @author Krzysztof Kukla
 */
@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable String id) {
        UserDto userDto = userService.getById(UUID.fromString(id));

        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.createUser(userDto);
        return ResponseEntity.created(URI.create("/v1/users/" + savedUser.getId().toString())).build();
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("location", "/v1/users/" + savedUser.getId().toString());
//        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable String id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}