package org.example.repo;

import org.example.model.Admin;
import org.example.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminRepository implements Repository<Admin>{
    private List<Admin> admins;

    public AdminRepository() {
        this.admins = new ArrayList<>();
    }

    @Override
    public List<Admin> getObjects() {
        return admins;
    }

    @Override
    public void save(Admin entity) {
        admins.add(entity);
    }

//    @Override
//    public void update(Admin entity) {
//
//    }

    @Override
    public void delete(Admin object) {
        admins.remove(object);
    }
}
