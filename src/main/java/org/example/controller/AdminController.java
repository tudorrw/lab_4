package org.example.controller;

import org.example.model.Admin;
import org.example.repo.AdminIRepository;
import java.util.List;

public class AdminController {
    private AdminIRepository adminIRepository;
    private int adminIdCounter;
    public AdminController(AdminIRepository adminRepository) {
        this.adminIRepository = adminRepository;
        this.adminIdCounter = adminRepository.getObjects().size() + 1;
    }

    public Admin findAdmin(String username) {
        List<Admin> database = adminIRepository.getObjects();
        for(Admin admin: database) {
            if(admin.getUsername().equals(username)){
                return admin;
            }
        }
        return null;
    }
    public boolean createAdmin(String username, String password, String adminRole) {
        if(findAdmin(username) != null) {
            return false;
        }
        Admin newAdmin = new Admin(adminIdCounter++, username, password, adminRole);
        adminIRepository.save(newAdmin);
        return true;
    }

    public void updateAdmin(Admin admin) {

    }

    public boolean deleteAdmin(String username) {
        Admin admin = findAdmin(username);
        if(admin == null) {
            return false;
        }
        adminIRepository.delete(admin);
        return true;
    }
}
