package co.donebyme.microservices.user.managment.controller;

import co.donebyme.microservices.user.managment.domain.model.User;
import co.donebyme.microservices.user.managment.domain.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aram Mkrtchyan.
 */
@RestController
@RequestMapping("/users")
public class UserController {


    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    UserView userByEmail(@RequestParam(name = "email") String email) {
        User user = userRepository.findByEmail(email);
        return new UserView(user.getEmail(), user.getId());
    }


}
