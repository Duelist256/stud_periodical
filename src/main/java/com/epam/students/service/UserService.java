package com.epam.students.service;

import com.epam.students.dao.UserDao;
import com.epam.students.model.User;

import java.security.NoSuchAlgorithmException;

/**
 * Service class for manipulations with User table entries and verification.
 */
public class UserService {

    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public boolean checkEmailExistens(String email){
        return userDao.readByEmail(email)!=null;
    }

    /**
     * Verifies email and password input bu user.
     *
     * @param email input by user
     * @param password input by user
     * @return User object if data is verified. Or null if it is not.
     */
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
