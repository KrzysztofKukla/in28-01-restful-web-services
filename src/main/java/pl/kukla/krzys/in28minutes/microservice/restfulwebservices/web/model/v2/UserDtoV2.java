package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.model.v2;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kukla.krzys.in28minutes.microservice.restfulwebservices.domain.v2.Name;

import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * @author Krzysztof Kukla
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDtoV2 {
    @Null
    private UUID id;

    //    @CreationTimestamp
//    @Null
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    @Past
//    @ApiModelProperty(notes = "Birth date must be in the past") //swagger
    private OffsetDateTime birthDate;

    @JsonIgnore
    private String password;
    private Name name;

}
