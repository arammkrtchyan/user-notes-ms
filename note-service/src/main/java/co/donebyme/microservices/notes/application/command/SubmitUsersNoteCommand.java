package co.donebyme.microservices.notes.application.command;

/**
 * @author Aram Mkrtchyan.
 */
public class SubmitUsersNoteCommand {


    private String userId;

    private String title;

    private String note;

    public SubmitUsersNoteCommand(String userId, String title, String note) {
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
