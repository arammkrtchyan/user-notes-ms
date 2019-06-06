package co.donebyme.microservices.notes.domain.model.author;

/**
 * In this domain represents the user who wrote the note.
 *
 * @author Aram Mkrtchyan.
 */
public class Author {

    private AuthorId userId;

    private String name;

    public Author(AuthorId userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public AuthorId getAuthorId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
