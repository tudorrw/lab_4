package org.example.test;

import org.example.controller.UserController;
import org.example.repo.UserIRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    private UserController userController;
    private UserIRepository userIRepository;

    @BeforeEach
    void setUp() {
        this.userIRepository = new UserIRepository();
        this.userController = new UserController(userIRepository);

    }
    @Test
    void findUser() {
        userController.createUser("testUser", "testPassword");
        assertNotNull(userController.findUser("testUser", "testPassword"));
        assertNull(userController.findUser("testUser", "wrongPassword"));
    }

    @Test
    void createUser() {
        assertTrue(userController.createUser("newUser", "newPassword"));
        assertFalse(userController.createUser("newUser", "newPassword"));
    }

    @Test
    void deleteUser() {
        userController.createUser("toBeDeleted", "teBeDeletedPass");
        assertTrue(userController.deleteUser("toBeDeleted", "teBeDeletedPass"));
        assertFalse(userController.deleteUser("nonExistingUser", "somePassword"));
    }
}