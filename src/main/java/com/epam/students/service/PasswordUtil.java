package com.epam.students.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

// From Joel Murach's book "Java Servlets and JSP" (3rd edition)

public class PasswordUtil {

    /**
     * Utility method for combining password and salt
     *
     * @param password is password, what else do you expect it to be?
     * @param salt provides more security for operations with password.
     * @return hashcode for combination of original password's hash and salt.
     * @throws NoSuchAlgorithmException from hashPassword method.
     */
    public static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        password = hashPassword(password);
        return hashPassword(password + salt);
    }

    /**
     * Calculating hashcode of user's password for some basic security.
     *
     * @param password is still a password.
     * @return hashcode representation of password.
     * @throws NoSuchAlgorithmException from MessageDigest.getInstance method.
     */
    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] bytes = password.getBytes();
        md.update(bytes);
        byte[] mdArray = md.digest();
        StringBuilder sb = new StringBuilder(mdArray.length * 2);
        for (byte b : mdArray) {
            int v = b & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString();
    }

    /**
     * Method to generate salt based on random seed.
     *
     * @return string of bytes encoded with Base 64 algorithm
     */
    public static String generateSalt() {
        Random r = new SecureRandom();
        byte[] saltBytes = new byte[32];
        r.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }
}
