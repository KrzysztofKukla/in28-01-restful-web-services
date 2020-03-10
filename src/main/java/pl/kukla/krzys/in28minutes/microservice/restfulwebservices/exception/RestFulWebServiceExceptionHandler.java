package pl.kukla.krzys.in28minutes.microservice.restfulwebservices.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * @author Krzysztof Kukla
 */

@ControllerAdvice
@Slf4j
public class RestFulWebServiceExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity userNotFound(UserNotFoundException ex, WebRequest webRequest) {
        log.error(ex.getMessage(), ex);
        //we return details Exception to output with specific format
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), webRequest.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity handleAll(Exception ex, WebRequest webRequest) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
