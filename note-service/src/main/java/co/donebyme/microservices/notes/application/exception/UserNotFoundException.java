package co.donebyme.microservices.notes.application.exception;

/**
 * @author Aram Mkrtchyan.
 */
public class UserNotFoundException extends IllegalArgumentException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
