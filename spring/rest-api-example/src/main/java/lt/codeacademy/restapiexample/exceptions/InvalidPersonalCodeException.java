package lt.codeacademy.restapiexample.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidPersonalCodeException extends RuntimeException {
    public InvalidPersonalCodeException(String details) {
        super(String.format("Invalid personal code: %s", details));
    }
}
