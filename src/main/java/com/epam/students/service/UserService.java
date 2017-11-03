package com.epam.students.service;

import com.epam.students.dao.UserDao;
import com.epam.students.model.User;

import java.security.NoSuchAlgorithmException;

public class UserService {

    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public User checkUser(String email, String password) {

        if (email == null || password == null) {
            return null;
        }

        User user = userDao.readByEmail(email);

        if (user == null) {
            return null;
        }

        String checkedPassword = null;
        try {
            checkedPassword = PasswordUtil.hashPassword(password, user.getSalt());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        if (checkedPassword.equals(user.getPassword())) {
            return user;
        } else {
            return null;
        }
        
    }

    public void addUser(String login, String password, String name) {

        String salt = PasswordUtil.generateSalt();
        String hashedPassword = null;

        try {
            hashedPassword = PasswordUtil.hashPassword(password, salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        User newUser = User.newBuilder()
                .name(name)
                .login(login)
                .salt(salt)
                .password(hashedPassword)
                .build();

        userDao.create(newUser);
    }
}
