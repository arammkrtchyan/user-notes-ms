package co.donebyme.microservices.notes.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Aram Mkrtchyan.
 */
@ResponseStatus(value= HttpStatus.FORBIDDEN, reason="Access denied to the requested note.")
public class NoteAccessDeniedException extends RuntimeException {

    public NoteAccessDeniedException(String message) {
        super(message);
    }
}
