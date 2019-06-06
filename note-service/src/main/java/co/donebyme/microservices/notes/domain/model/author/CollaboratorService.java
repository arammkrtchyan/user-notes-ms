package co.donebyme.microservices.notes.domain.model.author;

/**
 * @author Aram Mkrtchyan.
 */
public interface CollaboratorService {

    Author authorFrom(String identity);

}
