package co.donebyme.microservices.notes.domain.model.author;

import java.io.Serializable;

/**
 * @author Aram Mkrtchyan.
 */
public class AuthorId implements Serializable {

    private String id;

    public AuthorId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
