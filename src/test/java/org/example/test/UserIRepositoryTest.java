package org.example.test;

import org.example.model.User;
import org.example.repo.UserIRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserIRepositoryTest {
    private UserIRepository userIRepository;

    @BeforeEach
    void setUp(){
        this.userIRepository = new UserIRepository();
    }

    @Test
    void getObjects() {
        assertEquals(4, userIRepository.getObjects().size());
    }

    @Test
    void save() {
        User user = new User(5, "qwerty", "1234");
        userIRepository.save(user);
        assertEquals(5, userIRepository.getObjects().size());
    }

    @Test
    void delete() {
        User user1 = new User(5, "bogdan", "123");
        userIRepository.save(user1);
        userIRepository.delete(user1);
        assertEquals(4, userIRepository.getObjects().size());
    }
}