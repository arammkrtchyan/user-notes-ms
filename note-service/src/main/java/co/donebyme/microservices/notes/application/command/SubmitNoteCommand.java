package co.donebyme.microservices.notes.application.command;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Aram Mkrtchyan.
 */
public class SubmitNoteCommand {
    
    @NotNull
    private String userId;

    @Size(min = 0, max = 50)
    private String title;

    @Size(max = 1000)
    private String note;

    public SubmitNoteCommand(String userId, String title, String note) {
        this.userId = userId;
        this.title = title;
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public String getTitle() {
        return title;
    }

    public String getUserId() {
        return userId;
    }
}
