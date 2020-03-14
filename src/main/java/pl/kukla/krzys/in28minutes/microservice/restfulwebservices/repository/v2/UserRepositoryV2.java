package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.repository.v2;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain.v2.UserV2;

import java.util.UUID;

/**
 * @author Krzysztof Kukla
 */
public interface UserRepositoryV2 extends JpaRepository<UserV2, UUID> {
}
