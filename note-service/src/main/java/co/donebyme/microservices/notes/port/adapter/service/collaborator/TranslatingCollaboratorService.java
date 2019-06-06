package co.donebyme.microservices.notes.port.adapter.service.collaborator;

import co.donebyme.microservices.notes.domain.model.author.Author;
import co.donebyme.microservices.notes.domain.model.author.CollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Aram Mkrtchyan.
 */
@Service
public class TranslatingCollaboratorService implements CollaboratorService {

    private final UserInRoleAdapter adapter;

    @Autowired
    public TranslatingCollaboratorService(UserInRoleAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public Author authorFrom(String email) {
        return adapter.toAuthor(email);
    }
}
