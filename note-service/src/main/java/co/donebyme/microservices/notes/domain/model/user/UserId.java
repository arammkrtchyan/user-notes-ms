package co.donebyme.microservices.notes.domain.model.user;

/**
 * @author Aram Mkrtchyan.
 */
public class UserId {

    private String id;

    public UserId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
