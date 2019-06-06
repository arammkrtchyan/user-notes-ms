package co.donebyme.microservices.notes.port.adapter.service;

import co.donebyme.microservices.notes.domain.model.author.Author;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Aram Mkrtchyan.
 */
@Component
public class HttpUserInRoleAdapter implements UserInRoleAdapter {

    private RestTemplate restTemplate;

    private CollaboratorTranslator collaboratorTranslator = new CollaboratorTranslator();

    public HttpUserInRoleAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Author toAuthor(String email) {
        AuthorRepresentation representation = restTemplate.getForEntity(
                // TODO make configurable or use eureka
                "http://localhost:8081/user-management/users?email={email}",
                AuthorRepresentation.class,
                email
        ).getBody();
        return collaboratorTranslator.toAuthorFromRepresentation(representation);
    }

}
