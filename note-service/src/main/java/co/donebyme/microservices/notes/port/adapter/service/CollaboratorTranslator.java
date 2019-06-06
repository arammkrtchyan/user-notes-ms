package co.donebyme.microservices.notes.port.adapter.service;


import co.donebyme.microservices.notes.domain.model.author.Author;
import co.donebyme.microservices.notes.domain.model.author.AuthorId;

/**
 * @author Aram Mkrtchyan.
 */
class CollaboratorTranslator {


    Author toAuthorFromRepresentation(AuthorRepresentation representation) {
        return new Author(new AuthorId(representation.getId()), representation.getName());
    }

}
