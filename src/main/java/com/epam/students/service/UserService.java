package com.epam.students.service;

import com.epam.students.dao.UserDao;
import com.epam.students.model.User;

import java.security.NoSuchAlgorithmException;

public class UserService {
    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public boolean isUserCorrect(String email, String password) {

        if (email == null || password == null) {
            return false;
        }

        User user = userDao.readByEmail(email);

        if (user == null) {
            return false;
        }

        String checkedPassword = null;
        try {
            checkedPassword = PasswordUtil.hashPassword(password, user.getSalt());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return checkedPassword.equals(user.getPassword());
    }

    public void addUser(String login, String password, String name) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setLogin(login);

        String salt = PasswordUtil.generateSalt();
        String hashedPassword = null;
        try {
            hashedPassword = PasswordUtil.hashPassword(password, salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        newUser.setSalt(salt);
        newUser.setPassword(hashedPassword);

        userDao.create(newUser);
    }
}
