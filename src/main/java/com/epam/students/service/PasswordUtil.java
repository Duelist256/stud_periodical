package com.epam.students.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

// From Joel Murach's book "Java Servlets and JSP" (3rd edition)

public class PasswordUtil {

    public static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        password = hashPassword(password);
        return hashPassword(password + salt);
    }

    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] bytes = password.getBytes();
        System.out.println("String bytes: " + Arrays.toString(bytes));
        md.update(bytes);
        byte[] mdArray = md.digest();
        System.out.println("After digest: " + Arrays.toString(mdArray));
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

    public static String generateSalt() {
        Random r = new SecureRandom();
        byte[] saltBytes = new byte[32];
        r.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }
}
