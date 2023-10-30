package org.example.controller;

import org.example.model.Admin;
import org.example.repo.AdminRepository;

public class AdminController {
    private AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void createAdmin(Admin admin) {

    }

    public void updateAdmin(Admin admin) {

    }

    public void deleteAdmin(int adminId) {

    }
}
