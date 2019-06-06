package co.donebyme.microservices.notes.application.exception;

/**
 * @author Aram Mkrtchyan.
 */
public class UserNoteFoundException extends IllegalArgumentException {

    public UserNoteFoundException(String message) {
        super(message);
    }
}
