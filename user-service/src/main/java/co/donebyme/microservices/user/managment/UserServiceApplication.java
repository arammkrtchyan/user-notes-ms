package co.donebyme.microservices.user.managment;

import co.donebyme.microservices.user.managment.domain.model.User;
import co.donebyme.microservices.user.managment.domain.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {

    @Autowired
    public UserServiceApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }


    private final UserRepository userRepository;

    @Override
    public void run(String... args) {

        /*BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = new User(
                "aram@gmail.com",
                cryptPasswordEncoder.encode("encoded_password")
        );
        userRepository.save(user);*/
    }
}
