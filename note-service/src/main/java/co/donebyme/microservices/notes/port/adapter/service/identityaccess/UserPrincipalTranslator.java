package co.donebyme.microservices.notes.port.adapter.service.identityaccess;


import co.donebyme.microservices.notes.domain.model.identityaccess.User;

/**
 * @author Aram Mkrtchyan.
 */
class UserPrincipalTranslator {


    User toUserFroRepresentation(UserPrincipalRepresentation representation) {
        return new User(representation.getEmail(), representation.getPassword());
    }

}
