package com.epam.students.service;

import com.epam.students.dao.UserDao;
import com.epam.students.model.User;

import java.security.NoSuchAlgorithmException;

public class UserService {

    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public boolean checkEmailExistens(String email){
        return userDao.readByEmail(email)!=null;
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

    public void addUser(User user) {
        userDao.create(user);
    }
}
