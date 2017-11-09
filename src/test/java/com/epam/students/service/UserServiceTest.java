package com.epam.students.service;

import com.epam.students.dao.UserDao;
import com.epam.students.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Spy
    private UserDao userDao;

    @InjectMocks
    private UserService userService;

    @Test
    public void checkEmailExistence() throws Exception {
        String email = "test1@test.com";
        userService.checkEmailExistence(email);
        verify(userDao, times(1)).readByEmail(email);
    }

    @Test
    public void checkUser() throws Exception {
        String email = "test1@test.com";
        String password = "test1@test.com";
        userService.checkUser(email, password);
        verify(userDao, times(1)).readByEmail(email);
    }

    @Test
    public void addUser() throws Exception {
        User user = User
                .newBuilder()
                .name("Petya")
                .login("petya@mail.ru")
                .password("asdascdsf323d")
                .salt("aczasdas32d")
                .isAdmin(0)
                .build();
        userService.addUser(user);
        verify(userDao, times(1)).create(user);
    }
}