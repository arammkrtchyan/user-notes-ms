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
    public Author toAuthor(String identity) {
        AuthorRepresentation representation = restTemplate.getForEntity(
                "http://auth-service/users/{identity}",
                AuthorRepresentation.class,
                identity
        ).getBody();
        return collaboratorTranslator.toAuthorFromRepresentation(representation);
    }

}
