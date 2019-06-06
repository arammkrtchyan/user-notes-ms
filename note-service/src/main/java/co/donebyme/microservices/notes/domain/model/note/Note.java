package co.donebyme.microservices.notes.domain.model.note;

import co.donebyme.microservices.notes.domain.model.user.User;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * @author Aram Mkrtchyan.
 */
public class Note {

    private String title;

    private String note;

    private NoteId noteId;

    private User user;

    private ZonedDateTime dateRecordAdded;

    private ZonedDateTime modifiedDate;

    Note(String title, String note, User user) {
        this(title, note, user, NoteId.fromExisting(UUID.randomUUID().toString()));
    }

    private Note(String title, String note, User user, NoteId noteId) {
        this.title = title;
        this.note = note;
        this.user = user;
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public NoteId getNoteId() {
        return noteId;
    }

    public String getNote() {
        return note;
    }

    public User getUser() {
        return user;
    }

    public ZonedDateTime getDateRecordAdded() {
        return dateRecordAdded;
    }

    public ZonedDateTime getModifiedDate() {
        return modifiedDate;
    }
}
