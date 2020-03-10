package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
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
public class UserDto {

    @Null
    private UUID id;

    @NotBlank(message = "name cannot be blank")
    private String name;

    //    @CreationTimestamp
//    @Null
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    @Past
    private OffsetDateTime birthDate;

}
