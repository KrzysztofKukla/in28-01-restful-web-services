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
//Versioning by uri is preferred, because it allows caching services
@RequestMapping("/v2/users")
@RequiredArgsConstructor
public class UserControllerV2 {
    private final UserServiceV2 userServiceV2;

    @GetMapping
    public ResponseEntity<List<UserDtoV2>> getUsers() {
        List<UserDtoV2> users = userServiceV2.getAll();
        return ResponseEntity.ok(users);
    }

    //VERSIONING TYPES:
    //by params
//    @GetMapping(value = "/param", params = "version=1")
//    @GetMapping(value = "/param", params = "version=2")

    //by header - use in Headers X-API-VERSION = 1
//    @GetMapping(value = "/header", headers = "X-API-VERSION = 1")
//    @GetMapping(value = "/header", headers = "X-API-VERSION = 2")

    //by produces // use Accept = 'application/vnd.company.app-v1+json'
//    @GetMapping(value = "/produces", produces = "application/vnd.company.app-v1+json")
//    @GetMapping(value = "/produces", produces = "application/vnd.company.app-v2+json")

}
