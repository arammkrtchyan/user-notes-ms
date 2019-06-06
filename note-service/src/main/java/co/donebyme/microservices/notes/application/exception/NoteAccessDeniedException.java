package co.donebyme.microservices.notes.application.exception;

/**
 * @author Aram Mkrtchyan.
 */
public class NoteAccessDeniedException extends RuntimeException {

    public NoteAccessDeniedException(String message) {
        super(message);
    }
}
