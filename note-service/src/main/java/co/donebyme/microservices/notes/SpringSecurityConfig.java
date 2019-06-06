package co.donebyme.microservices.notes;

import co.donebyme.microservices.notes.domain.model.identityaccess.IdentityAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Aram Mkrtchyan.
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final IdentityAccessService identityAccessService;

    @Autowired
    public SpringSecurityConfig(
            IdentityAccessService identityAccessService) {
        this.identityAccessService = identityAccessService;
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(identityAccessService)
                .passwordEncoder(encoder());
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }

}
