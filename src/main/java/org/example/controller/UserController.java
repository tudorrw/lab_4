package org.example.controller;

import org.example.repo.UserRepository;
import org.example.model.User;

public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void createUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUser(int userId) {

    }

}
