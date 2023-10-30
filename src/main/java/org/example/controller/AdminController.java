package org.example.controller;

import org.example.model.Admin;
import org.example.repo.AdminIRepository;

public class AdminController {
    private AdminIRepository adminRepository;

    public AdminController(AdminIRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void createAdmin(Admin admin) {

    }

    public void updateAdmin(Admin admin) {

    }

    public void deleteAdmin(int adminId) {

    }
}
