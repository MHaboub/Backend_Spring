package com.gestionformation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.gestionformation.models.User;
import com.gestionformation.models.Role;
import com.gestionformation.repositories.UserRepository;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAllByOrderByLastNameAsc();
    }

    public User getUser(Long id) {
        return userRepository.findByIdAndDeletedFalse(id);
    }

    public User createUser(String username, String password, String firstName,
            String lastName, Role role) {
        if (findByUsername(username) != null) {
            throw new IllegalArgumentException("Username already exists");
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setRole(role);

        return userRepository.save(newUser);
    }

    public User updateUser(Long id, String username, String firstName,
            String lastName, Role role) {
        User user = getUser(id);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRole(role);

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
