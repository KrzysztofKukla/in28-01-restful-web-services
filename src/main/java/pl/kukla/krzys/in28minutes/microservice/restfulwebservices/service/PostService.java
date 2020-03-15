package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.service;

import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.model.PostDto;

import java.util.List;
import java.util.UUID;

/**
 * @author Krzysztof Kukla
 */
public interface PostService {

    List<PostDto> getPostByUserId(UUID userId);

    PostDto createPostForUser(UUID userId, PostDto postDto);

}
