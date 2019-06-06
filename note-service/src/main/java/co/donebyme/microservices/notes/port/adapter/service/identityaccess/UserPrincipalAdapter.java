package co.donebyme.microservices.notes.port.adapter.service.identityaccess;

import co.donebyme.microservices.notes.domain.model.identityaccess.User;

/**
 * @author Aram Mkrtchyan.
 */
public interface UserPrincipalAdapter {

    User toUser(String email);

}
