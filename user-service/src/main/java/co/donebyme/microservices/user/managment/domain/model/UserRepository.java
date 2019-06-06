package co.donebyme.microservices.user.managment.domain.model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Aram Mkrtchyan.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
