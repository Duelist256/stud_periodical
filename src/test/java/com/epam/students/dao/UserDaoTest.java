package com.epam.students.dao;

import com.epam.students.model.User;
import com.epam.students.service.PasswordUtil;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void createAndReadUser() throws NoSuchAlgorithmException {
        String login = "testuser1@test.com";
        String salt = PasswordUtil.generateSalt();
        String password = PasswordUtil.hashPassword("test", salt);
        String name = "TestUser10";

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setSalt(salt);
        user.setName(name);

        UserDao userDao = new UserDao();
        userDao.create(user);

        User receivedUser = userDao.read(login);

        assertEquals(login, receivedUser.getLogin());
        assertEquals(password, receivedUser.getPassword());
        assertEquals(salt, receivedUser.getSalt());
        assertEquals(name, receivedUser.getName());
        assertEquals(0, receivedUser.getIsAdmin());
    }

    @Test
    public void updateAndReadUser() throws Exception {
        User user = new User();
        String newLogin = "user1@test.com";
        String newPassword = "user1";
        String newSalt = "salt1";
        String newName = "USER1";

        user.setId(1);
        user.setLogin(newLogin);
        user.setPassword(newPassword);
        user.setSalt(newSalt);
        user.setName(newName);

        UserDao userDao = new UserDao();
        userDao.update(user);

        User readUser = userDao.read(newLogin);

        assertEquals(1, readUser.getId());
        assertEquals(readUser.getPassword(), newPassword);
        assertEquals(readUser.getSalt(), newSalt);
        assertEquals(readUser.getName(), newName);
    }

    @Test
    public void readAndDeleteUser() throws Exception {
        UserDao userDao = new UserDao();

        User readUser = userDao.read("test10@test.com");
        assertNotNull(readUser);
        userDao.delete(readUser);

        User readUser2 = userDao.read("test10@test.com");
        assertNull(readUser2);
    }

    @Test
    public void getAllUsers() throws Exception {
        UserDao userDao = new UserDao();
        List<User> users = userDao.getAll();
        assertFalse(users.isEmpty());
    }
}