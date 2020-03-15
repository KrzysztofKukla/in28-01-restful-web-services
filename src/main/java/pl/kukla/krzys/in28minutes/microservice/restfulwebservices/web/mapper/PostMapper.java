package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.mapper;

import org.mapstruct.Mapper;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain.Post;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.model.PostDto;

/**
 * @author Krzysztof Kukla
 */
@Mapper(componentModel = "spring")
public interface PostMapper {

    PostDto postToPostDto(Post post);

    Post postDtoToPost(PostDto postDto);

}
