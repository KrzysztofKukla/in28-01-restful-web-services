package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Krzysztof Kukla
 */

@ControllerAdvice
public class RestFulWebServiceExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity userNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity handleAll() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
