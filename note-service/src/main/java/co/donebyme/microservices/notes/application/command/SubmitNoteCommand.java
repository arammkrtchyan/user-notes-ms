package co.donebyme.microservices.notes.application.command;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Aram Mkrtchyan.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubmitNoteCommand {

    @JsonIgnore
    private String email;

    @Size(min = 0, max = 50)
    private String title;

    @Size(max = 1000)
    private String note;

    public SubmitNoteCommand(String email, String title, String note) {
        this.email = email;
        this.title = title;
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public SubmitNoteCommand setEmail(String email) {
        this.email = email;
        return this;
    }
}
