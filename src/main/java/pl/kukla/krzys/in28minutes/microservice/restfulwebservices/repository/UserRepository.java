package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain.User;

import java.util.UUID;

/**
 * @author Krzysztof Kukla
 */
public interface UserRepository extends JpaRepository<User, UUID> {
}
