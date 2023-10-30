package org.example.controller;

import org.example.repo.UserIRepository;
import org.example.model.User;

public class UserController {
    private UserIRepository userRepository;

    public UserController(UserIRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void createUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUser(int userId) {

    }

}
