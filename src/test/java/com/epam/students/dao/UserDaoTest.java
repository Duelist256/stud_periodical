package com.epam.students.dao;

import com.epam.students.model.User;
import com.epam.students.service.PasswordUtil;
import org.junit.Before;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

public class UserDaoTest {

    private UserDao userDao;

    private User user;

    private int id = 42;
    private String login = "testuser1@test.com";
    private String salt = PasswordUtil.generateSalt();
    private String password = PasswordUtil.hashPassword("test", salt);
    private String name = "TestUser10";
    private int isAdmin = 1;

    public UserDaoTest() throws NoSuchAlgorithmException {
    }

    @Before
    public void setUserDao() {
        userDao = new UserDao();
    }

    @Before
    public void setUser() {
        user = new User();
        user.setId(42);
        user.setLogin(login);
        user.setPassword(password);
        user.setSalt(salt);
        user.setName(name);
        user.setIsAdmin(isAdmin);
    }

    @Test
    public void addUser() {
        userDao.create(user);
    }

    @Test
    public void getUser() {
        userDao.read(login);
    }

    @Test
    public void checkId() {
        assertEquals(id, user.getId());
    }

    @Test
    public void checkEmail() {
        assertEquals(login, user.getLogin());
    }

    @Test
    public void checkPassword() {
        assertEquals(password, user.getPassword());
    }

    @Test
    public void checkSalt() {
        assertEquals(salt, user.getSalt());
    }

    @Test
    public void checkName() {
        assertEquals(name, user.getName());
    }

    @Test
    public void checkIsAdmin() {
        assertEquals(isAdmin, user.getIsAdmin());
    }
}