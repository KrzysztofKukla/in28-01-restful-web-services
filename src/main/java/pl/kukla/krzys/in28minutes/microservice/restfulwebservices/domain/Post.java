package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain.v2.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

/**
 * @author Krzysztof Kukla
 */
@Entity
@Getter
@Setter
@ToString(exclude = "user")
@EqualsAndHashCode(exclude = "user", callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseEntity {

    @Builder
    public Post(UUID id, String description, User user) {
        super(id);
        this.description = description;
        this.user = user;
    }

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id") //name of column in User table
    private User user;

}
