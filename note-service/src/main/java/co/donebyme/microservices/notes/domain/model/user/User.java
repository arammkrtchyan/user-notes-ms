package co.donebyme.microservices.notes.domain.model.user;

/**
 * In this domain represents the user who wrote the note.
 *
 * @author Aram Mkrtchyan.
 */
public class User {

    private UserId userId;

    public User(UserId userId) {
        this.userId = userId;
    }

    public UserId getUserId() {
        return userId;
    }
}
