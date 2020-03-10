package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Krzysztof Kukla
 */
public interface UserRepository extends JpaRepository<User, UUID> {
}
