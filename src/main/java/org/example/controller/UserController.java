package org.example.controller;

import org.example.repo.UserIRepository;
import org.example.model.User;

import java.util.List;

public class UserController {
    private UserIRepository userIRepository;
    private int userIdCounter;

    public UserController(UserIRepository userIRepository) {
        this.userIRepository = userIRepository;
        this.userIdCounter = userIRepository.getObjects().size() + 1;
    }

    public User findUser(String username) {
        List<User> database = userIRepository.getObjects();
        for(User user: database) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    public boolean createUser(String username, String password) {
        if(findUser(username) != null) {
            return false;
        }
        User newUser = new User(userIdCounter++, username, password);
        userIRepository.save(newUser);
        return true;
    }

    public void updateUser() {
        List<User> database = userIRepository.getObjects();
        for (User user: database) {
            System.out.println(user.toString());
        }
    }

    public boolean deleteUser(String username) {
        User user = findUser(username);
        if(user == null) {
            return false;
        }
        userIRepository.delete(user);
        return true;
    }


}
