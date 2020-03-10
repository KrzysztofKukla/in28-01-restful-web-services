package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author Krzysztof Kukla
 */
@Data
@AllArgsConstructor
public class ExceptionResponse {
    private Date date;
    private String message;
    private String details;

}
