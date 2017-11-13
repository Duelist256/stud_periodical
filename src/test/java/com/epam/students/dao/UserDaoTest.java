package com.epam.students.dao;

import com.epam.students.model.User;
import com.epam.students.utils.PasswordUtil;
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

        User user = User.newBuilder()
                .login(login)
                .password(password)
                .salt(salt)
                .name(name)
                .build();

        UserDao userDao = new UserDao();
        userDao.create(user);

        User receivedUser = userDao.readByEmail(login);

        assertEquals(login, receivedUser.getLogin());
        assertEquals(password, receivedUser.getPassword());
        assertEquals(salt, receivedUser.getSalt());
        assertEquals(name, receivedUser.getName());
        assertEquals(0, receivedUser.isAdmin());
    }

    @Test
    public void updateAndReadUser() throws Exception {

        String newLogin = "user1@test.com";
        String newPassword = "user1";
        String newSalt = "salt1";
        String newName = "USER1";
        User user = User.newBuilder()
                .id(1)
                .login(newLogin)
                .password(newPassword)
                .salt(newSalt)
                .name(newName)
                .build();

        UserDao userDao = new UserDao();
        userDao.update(user);

        User readUser = userDao.readByEmail(newLogin);

        assertEquals(1, readUser.getId());
        assertEquals(newPassword ,readUser.getPassword());
        assertEquals(newSalt, readUser.getSalt());
        assertEquals(newName, readUser.getName());
    }

    @Test
    public void readAndDeleteUser() throws Exception {
        UserDao userDao = new UserDao();

        User readUser = userDao.read(5);
        assertNotNull(readUser);
        userDao.delete(readUser);

        User readUser2 = userDao.read(5);
        assertNull(readUser2);
    }

    @Test
    public void getAllUsers() throws Exception {
        UserDao userDao = new UserDao();
        List<User> users = userDao.getAll();
        assertFalse(users.isEmpty());
    }
}