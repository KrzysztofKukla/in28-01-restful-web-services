package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain.Post;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain.User;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.exception.UserNotFoundException;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.repository.PostRepository;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.repository.UserRepository;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.mapper.PostMapper;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.model.PostDto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Krzysztof Kukla
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostMapper postMapper;

    @Override
    public List<PostDto> getPostByUserId(UUID userId) {
        return postRepository.findAllByUserId(userId).stream()
            .map(postMapper::postToPostDto).collect(Collectors.toList());

    }

    @Override
    public PostDto createPostForUser(UUID userId, PostDto postDto) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException("User for " + userId.toString() + " does not exist"));
        Post post = postMapper.postDtoToPost(postDto);
        post.setUser(user);
        Post savedPost = postRepository.save(post);
        log.debug("Post for {} user has been saved", userId.toString());
        return postMapper.postToPostDto(savedPost);
    }

}
