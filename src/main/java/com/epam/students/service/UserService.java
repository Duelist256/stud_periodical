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

        User user = userDao.read(email);

        if (user == null) {
            return false;
        }

        System.err.println(user.getId());
        System.err.println(user.getLogin());
        System.err.println(user.getPassword());
        System.err.println(user.getName());
        System.err.println(user.getIsAdmin());


        String checkedPassword = null;
        try {
            checkedPassword = PasswordUtil.hashPassword(password, user.getSalt());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        assert checkedPassword != null;
        return checkedPassword.equals(user.getPassword());
    }

    public void addUser(String login, String password, String name) {

        String salt = PasswordUtil.generateSalt();
        String hashedPassword = null;

        try {
            hashedPassword = PasswordUtil.hashPassword(password, salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        User newUser = new User.Builder()
                .withName(name)
                .withLogin(login)
                .withSalt(salt)
                .withPassword(hashedPassword)
                .build();

        userDao.create(newUser);
    }
}
