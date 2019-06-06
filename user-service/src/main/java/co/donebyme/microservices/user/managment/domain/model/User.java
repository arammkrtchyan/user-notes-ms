package co.donebyme.microservices.user.managment.domain.model;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * @author Aram Mkrtchyan.
 */
@Entity
@Table(name = "system_user")
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String email;

    private String password;

    private ZonedDateTime dateRecordAdded;

    private ZonedDateTime modifiedDate;

    @PreUpdate
    public void preUpdate() {
        modifiedDate = ZonedDateTime.now();
    }

    public User(
            String email,
            String password) {
        this.email = email;
        this.password = password;
        this.dateRecordAdded = ZonedDateTime.now();
    }

    public ZonedDateTime getModifiedDate() {
        return modifiedDate;
    }

    public ZonedDateTime getDateRecordAdded() {
        return dateRecordAdded;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
