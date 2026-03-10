package uz.java.spring_boot_application.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uz.java.spring_boot_application.exception.GenericNotFoundException;
import uz.java.spring_boot_application.util.Translator;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
//@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final Translator translator;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleError(final MethodArgumentNotValidException ex) {
//        log.error("MethodArgumentNotValidException on: {}", ErrorUtil.getStacktrace(ex));
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError ->
                {
                    if (!translator.toLocale(fieldError.getDefaultMessage()).equals(fieldError.getDefaultMessage())) {
                        return Objects.requireNonNull(translator.toLocale(fieldError.getDefaultMessage()));
                    } else {
                        return fieldError.getField() + ": " + fieldError.getDefaultMessage();
                    }

                }).toList();
        return new ResponseEntity<>(Map.of("message", errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GenericNotFoundException.class)
    public ResponseEntity<?> handleGenericNotFoundException(final GenericNotFoundException e) {
//        log.error("GenericNotFoundException on: {}", ErrorUtil.getStacktrace(e));
        String message = translator.toLocale(e.getMessage());
        return new ResponseEntity<>(Map.of("message", List.of(message)), new HttpHeaders(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({RuntimeException.class, Throwable.class})
    public ResponseEntity<?> handleException(final Exception e) {
//        log.error("Exception on: {}", ErrorUtil.getStacktrace(e));
        return new ResponseEntity<>(Map.of("message", e.getMessage()), new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
