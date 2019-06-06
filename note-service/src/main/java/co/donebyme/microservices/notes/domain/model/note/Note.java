package co.donebyme.microservices.notes.domain.model.note;

import co.donebyme.microservices.notes.domain.model.user.User;

import java.time.ZonedDateTime;
import java.util.Objects;
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
        this.title = validateTitle(title);
        this.note = validateNote(note);
        this.user = Objects.requireNonNull(user, "User who added the not should be specified");
        this.noteId = noteId;
        this.dateRecordAdded = ZonedDateTime.now();
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

    private static String validateTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title can not be empty");
        } else if (title.length() >= 50) {
            throw new IllegalArgumentException("Length of the note's title can not exceed 50.");
        } else {
            return title;
        }
    }

    private static String validateNote(String note) {
        if (note != null && note.length() >= 1000) {
            throw new IllegalArgumentException("Length of the not can not exceed 1000.");
        } else {
            return note;
        }
    }
}
