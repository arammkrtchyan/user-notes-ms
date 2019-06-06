package co.donebyme.microservices.notes.domain.model.identityaccess;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Aram Mkrtchyan.
 */
public interface IdentityAccessService extends UserDetailsService  {

    User toSystemUser(String email);

}
