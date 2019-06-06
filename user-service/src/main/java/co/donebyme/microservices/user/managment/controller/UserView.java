package co.donebyme.microservices.user.managment.controller;

/**
 * @author Aram Mkrtchyan.
 */
public class UserView {

    private String email;

    private long id;

    UserView(String email, long id) {
        this.email = email;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }
}
