package uz.java.spring_boot_application.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
public class GenericNotFoundException extends RuntimeException {

    private String field;

    public GenericNotFoundException(String message) {
        super(message);
    }
    public GenericNotFoundException(String field, String message) {
        super(message);
        this.field = field;
    }
}
