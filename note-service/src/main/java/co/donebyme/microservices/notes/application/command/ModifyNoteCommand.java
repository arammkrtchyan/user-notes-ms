package co.donebyme.microservices.notes.application.command;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Size;

/**
 * @author Aram Mkrtchyan.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModifyNoteCommand {

    private String modifierUserId;

    private String noteId;

    @Size(min = 0, max = 50)
    private String title;

    @Size(max = 1000)
    private String note;

    public ModifyNoteCommand(String noteId, String modifierUserId, String title, String note) {
        this.title = title;
        this.note = note;
        this.noteId = noteId;
        this.modifierUserId = modifierUserId;
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

    public String getModifierUserId() {
        return modifierUserId;
    }
}
