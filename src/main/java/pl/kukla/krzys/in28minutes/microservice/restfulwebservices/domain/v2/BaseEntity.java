package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain.v2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Krzysztof Kukla
 */
//this indicates that object is not be created in database
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID") //Hibernate automatically will generate UUID settings for us
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    //UUID is mapping to varchar and to easy read it from database we need to define type explicitly
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

}
