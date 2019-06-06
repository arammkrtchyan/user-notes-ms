package co.donebyme.microservices.notes.port.adapter.service.identityaccess;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Aram Mkrtchyan.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPrincipalRepresentation {

    private String email;

    private String password;

    @JsonCreator
    public UserPrincipalRepresentation(
            @JsonProperty("email") String email,
            @JsonProperty("password") String password) {
        this.email = email;
        this.password = password;
    }

    String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
