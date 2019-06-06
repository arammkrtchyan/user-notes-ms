package co.donebyme.microservices.notes.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Aram Mkrtchyan.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Note ot found.")
public class NoteNotFoundException extends IllegalArgumentException {

    public NoteNotFoundException(String message) {
        super(message);
    }
}
