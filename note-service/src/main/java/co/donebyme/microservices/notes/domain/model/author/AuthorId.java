package co.donebyme.microservices.notes.domain.model.author;

/**
 * @author Aram Mkrtchyan.
 */
public class AuthorId {

    private String id;

    public AuthorId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
