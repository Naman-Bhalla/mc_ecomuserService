package dev.naman.mc_ecomuserservice.service;

import dev.naman.mc_ecomuserservice.models.User;
import dev.naman.mc_ecomuserservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Value("${server.port}")
    private String port;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signUp(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public boolean verifyUser(String email, String password) {
        System.out.println("Request to verify user at port: " + port);
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) {
            return false;
        }

        User fetchedUser = user.get();

        if (!fetchedUser.getPassword().equals(password)) {
            return false;
        }

        return true;
    }
}
