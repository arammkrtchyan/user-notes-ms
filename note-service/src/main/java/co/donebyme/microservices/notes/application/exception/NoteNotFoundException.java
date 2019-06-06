package co.donebyme.microservices.notes.application.exception;

/**
 * @author Aram Mkrtchyan.
 */
public class NoteNotFoundException extends IllegalArgumentException {

    public NoteNotFoundException(String message) {
        super(message);
    }
}
