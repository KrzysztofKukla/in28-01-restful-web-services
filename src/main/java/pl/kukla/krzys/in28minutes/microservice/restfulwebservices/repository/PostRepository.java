package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain.Post;

import java.util.List;
import java.util.UUID;

/**
 * @author Krzysztof Kukla
 */
public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findAllByUserId(UUID userId);

}
