package co.donebyme.microservices.notes.domain.model.note;

/**
 * Note's identity value.
 *
 * @author Aram Mkrtchyan.
 */
public class NoteId {


    /**
     * Constructs Note id from existing identity.
     */
    static NoteId fromExisting(String id) {
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
