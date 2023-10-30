package org.example.repo;

import org.example.model.Admin;
import org.example.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminRepository implements Repository<Admin, Integer>{
    private Map<Integer, User> users = new HashMap<>();

    @Override
    public Admin getById(Integer integer) {
        return null;
    }

    @Override
    public List<Admin> getObjects() {
        return null;
    }

    @Override
    public void save(Admin entity) {

    }

    @Override
    public void update(Admin entity) {

    }

    @Override
    public void delete(Integer integer) {

    }
}
