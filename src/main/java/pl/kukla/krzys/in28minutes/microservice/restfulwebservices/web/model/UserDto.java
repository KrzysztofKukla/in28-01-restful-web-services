package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
//@ApiModel(description = "UserDto description")
public class UserDto {

    @Null
    private UUID id;

    //    @ApiModelProperty(notes = "Name cannot be blank") //swagger
    @NotBlank(message = "name cannot be blank")
    private String name;

    //    @CreationTimestamp
//    @Null
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    @Past
//    @ApiModelProperty(notes = "Birth date must be in the past") //swagger
    private OffsetDateTime birthDate;

    @JsonIgnore
    private String password;

}
