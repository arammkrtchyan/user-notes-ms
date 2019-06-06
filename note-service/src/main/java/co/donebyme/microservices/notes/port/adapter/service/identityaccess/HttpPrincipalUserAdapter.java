package co.donebyme.microservices.notes.port.adapter.service.identityaccess;

import co.donebyme.microservices.notes.domain.model.identityaccess.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Aram Mkrtchyan.
 */
@Component
public class HttpPrincipalUserAdapter implements UserPrincipalAdapter {

    private RestTemplate restTemplate;

    private UserPrincipalTranslator translator = new UserPrincipalTranslator();

    public HttpPrincipalUserAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public User toUser(String email) {
        UserPrincipalRepresentation representation = restTemplate.getForEntity(
                // TODO make configurable or use eureka
                "http://localhost:8081/user-management/users?email={email}",
                UserPrincipalRepresentation.class,
                email
        ).getBody();

        return translator.toUserFroRepresentation(representation);
    }

}
