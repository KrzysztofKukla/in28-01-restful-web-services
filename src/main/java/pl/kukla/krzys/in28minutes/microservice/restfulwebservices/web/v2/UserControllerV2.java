package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.service.v2.UserServiceV2;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.model.v2.UserDtoV2;

import java.util.List;

/**
 * @author Krzysztof Kukla
 */
@RestController
@RequestMapping("/v2/users")
@RequiredArgsConstructor
public class UserControllerV2 {
    private final UserServiceV2 userServiceV2;

    @GetMapping
    public ResponseEntity<List<UserDtoV2>> getUsers() {
        List<UserDtoV2> users = userServiceV2.getAll();
        return ResponseEntity.ok(users);
    }

}
