package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.repository.PostRepository;
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
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public List<PostDto> getPostByUserId(UUID userId) {
        return postRepository.findAllByUserId(userId).stream()
            .map(postMapper::postToPostDto).collect(Collectors.toList());

    }

}
