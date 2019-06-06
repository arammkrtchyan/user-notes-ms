package co.donebyme.microservices.notes.port.adapter.service.identityaccess;

import co.donebyme.microservices.notes.domain.model.identityaccess.IdentityAccessService;
import co.donebyme.microservices.notes.domain.model.identityaccess.User;
import co.donebyme.microservices.notes.domain.model.identityaccess.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author Aram Mkrtchyan.
 */
@Component
public class TranslatingIdentityAccessService implements IdentityAccessService {

    private final UserPrincipalAdapter adapter;

    @Autowired
    public TranslatingIdentityAccessService(UserPrincipalAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public User toSystemUser(String email) {
        return adapter.toUser(email);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new UserPrincipal(toSystemUser(s));
    }
}
