package com.epam.students.dao;

import com.epam.students.model.User;
import com.epam.students.service.PasswordUtil;
import org.junit.Before;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;

public class UserDaoTest {

    private UserDao userDao;


    private User user;
    private String login;
    private String salt;
    private String password;
    private String name;

    @Before
    public void setUserDao() {

    }

    public UserDaoTest() throws NoSuchAlgorithmException {
        login = "testuser1@test.com";
        salt = PasswordUtil.generateSalt();
        password = PasswordUtil.hashPassword("test", salt);
        name = "TestUser10";

        user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setSalt(salt);
        user.setName(name);

        userDao = new UserDao();
        userDao.create(user);
    }

    @Test
    public void getAndCheckUser() {
        User receivedUser = userDao.read(login);

        assertEquals(login, receivedUser.getLogin());
        assertEquals(password, receivedUser.getPassword());
        assertEquals(salt, receivedUser.getSalt());
        assertEquals(name, receivedUser.getName());
        assertEquals(0, receivedUser.getIsAdmin());
    }

}