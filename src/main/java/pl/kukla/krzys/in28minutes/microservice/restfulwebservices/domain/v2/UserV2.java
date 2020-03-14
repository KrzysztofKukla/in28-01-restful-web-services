package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain.v2;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * @author Krzysztof Kukla
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserV2 extends BaseEntity {

    @Builder
    public UserV2(UUID id, Timestamp birthDate, String password, Name name) {
        super(id);
        this.birthDate = birthDate;
        this.password = password;
        this.name = name;
    }

    //    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp birthDate;

    private String password;

    @Embedded
    private Name name;

}
