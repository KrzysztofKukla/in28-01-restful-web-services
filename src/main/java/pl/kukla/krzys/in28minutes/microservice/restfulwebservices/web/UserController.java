package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.service.PostService;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.service.UserService;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.model.PostDto;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.model.UserDto;

import javax.validation.Valid;
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
    private final PostService postService;
    private final MessageSource messageSource;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> users = userService.getAll();
        String message = messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
        log.debug(message);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/dynamic-filter")
    public ResponseEntity<MappingJacksonValue> getUsersDynamicFiltering() {
        List<UserDto> users = userService.getAll();
        String message = messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
        log.debug(message);
        MappingJacksonValue mappingJacksonValue = dynamicFilterFields(users);
        return ResponseEntity.ok(mappingJacksonValue);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable String id) {
        UserDto userDto = userService.getById(UUID.fromString(id));

        //here we are building link to 'getUsers()' method
//        EntityModel<UserDto> entityModel = new EntityModel<UserDto>(userDto);
//        WebMvcLinkBuilder getUsersLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getUsers());

        //here we define name of link
//        entityModel.add(getUsersLink.withRel("all-users"));
//        return entityModel;

        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsForUser(@PathVariable UUID userId) {
        List<PostDto> posts = postService.getPostByUserId(userId);
        return ResponseEntity.ok(posts);
    }

    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody UserDto userDto) {
        UserDto savedUser = userService.createUser(userDto);
        return ResponseEntity.created(URI.create("/v1/users/" + savedUser.getId().toString())).build();
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("location", "/v1/users/" + savedUser.getId().toString());
//        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PostMapping(value = "/{userId}/posts")
    public ResponseEntity addPostToUser(@PathVariable UUID userId, @Valid @RequestBody PostDto postDto) {
        PostDto savedPostDto = postService.createPostForUser(userId, postDto);
        URI location = URI.create("/users/" + userId.toString() + "/posts" + savedPostDto.getId().toString());
        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable String id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private MappingJacksonValue dynamicFilterFields(List<UserDto> users) {

        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("name");
        FilterProvider filterProvider = new SimpleFilterProvider()
            .addFilter("customFilterId", simpleBeanPropertyFilter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(users);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }

}
