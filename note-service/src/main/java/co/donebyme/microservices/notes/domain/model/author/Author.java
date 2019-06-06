package co.donebyme.microservices.notes.domain.model.author;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * In this domain represents the user who wrote the note.
 *
 * @author Aram Mkrtchyan.
 */
@Embeddable
public class Author {

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "author_id"))
    private AuthorId authorId;

    private String name;

    public Author(AuthorId authorId, String name) {
        this.authorId = authorId;
        this.name = name;
    }

    public AuthorId getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }
}
