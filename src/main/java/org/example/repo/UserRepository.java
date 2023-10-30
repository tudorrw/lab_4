package org.example.repo;

import org.example.model.User;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserRepository implements Repository<User>{
    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    @Override
    public List<User> getObjects() {
        return users;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

//    @Override
//    public void update(User user) {
//
//    }

    @Override
    public void delete(User object) {
        users.remove(object);
    }
}