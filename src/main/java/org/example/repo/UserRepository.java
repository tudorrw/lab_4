package org.example.repo;

import org.example.model.User;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserRepository implements Repository<User, Integer>{
    private Map<Integer, User> users = new HashMap<>();

    @Override
    public User getById(Integer id) {
        return users.get(id);
    }

    @Override
    public List<User> getObjects() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Integer id) {
        users.remove(id);
    }
}
