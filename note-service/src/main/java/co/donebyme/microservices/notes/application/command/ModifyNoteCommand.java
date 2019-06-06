package co.donebyme.microservices.notes.application.command;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Size;

/**
 * @author Aram Mkrtchyan.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModifyNoteCommand {

    @JsonIgnore
    private String modifierUser;

    private String noteId;

    @Size(min = 0, max = 50)
    private String title;

    @Size(max = 1000)
    private String note;

    public ModifyNoteCommand(String title, String note) {
        this.title = title;
        this.note = note;
    }

    public ModifyNoteCommand setModifierUser(String modifierUser) {
        this.modifierUser = modifierUser;
        return this;
    }

    public ModifyNoteCommand setNoteId(String noteId) {
        this.noteId = noteId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }

    public String getNoteId() {
        return noteId;
    }

    public String getModifierUser() {
        return modifierUser;
    }
}
