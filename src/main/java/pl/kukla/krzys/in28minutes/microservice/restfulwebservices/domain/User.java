package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain.v2.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

/**
 * @author Krzysztof Kukla
 */
@Entity
@Getter
@Setter
@ToString(exclude = "posts")
@EqualsAndHashCode(exclude = "posts", callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Builder
    public User(UUID id, String name, Timestamp birthDate, String password, Set<Post> posts) {
        super(id);
        this.name = name;
        this.birthDate = birthDate;
        this.password = password;
        this.posts = posts;
    }

    private String name;

    //    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp birthDate;

    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Post> posts;

}
