package co.donebyme.microservices.notes.domain.model.note;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Note's identity value.
 *
 * @author Aram Mkrtchyan.
 */
@Embeddable
public class NoteId implements Serializable {


    /**
     * Constructs Note id from existing identity.
     */
    public static NoteId fromExisting(String id) {
        return new NoteId(id);
    }

    private String id;

    private NoteId(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
