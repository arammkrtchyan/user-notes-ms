package co.donebyme.microservices.notes.port.adapter.service.collaborator;

import co.donebyme.microservices.notes.domain.model.author.Author;

/**
 * @author Aram Mkrtchyan.
 */
public interface UserInRoleAdapter {

    Author toAuthor(String identity);

}
