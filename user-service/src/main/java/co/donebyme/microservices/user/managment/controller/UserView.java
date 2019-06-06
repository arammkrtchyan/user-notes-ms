package co.donebyme.microservices.user.managment.controller;

/**
 * @author Aram Mkrtchyan.
 */
public class UserView {

    private String email;

    private long id;

    private String password;

    UserView(String email, long id, String password) {
        this.email = email;
        this.id = id;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
