package com.epam.students.servlet;

import com.epam.students.dao.UserDao;
import com.epam.students.model.User;
import com.epam.students.service.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = "/resetPassword")
public class ResetPasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean reset = false;

        String emailChange = req.getParameter("emailChange");

        if (emailChange == null) {
            req.setAttribute("reset", reset);
            req.getServletContext().getRequestDispatcher("/passwordForm.jsp").forward(req, resp);
            return;
        }

        if (emailChange.equals("changeEmail")) {

            String email = req.getParameter("email");

            UserDao userDao = new UserDao();
            User user = userDao.readByEmail(email);

            if (user == null) {
                req.setAttribute("error", "Invalid email or password");
            } else {
                reset = !reset;
                req.setAttribute("useremail", email);
            }

            req.setAttribute("reset", reset);
            req.getServletContext().getRequestDispatcher("/passwordForm.jsp").forward(req, resp);
        }

        if (emailChange.equals("approveChange")) {
            String email = req.getParameter("email");
            String password = req.getParameter("pass");

            UserDao userDao = new UserDao();
            User user = userDao.readByEmail(email);

            String salt = PasswordUtil.generateSalt();
            String newPassword = null;
            try {
                newPassword = PasswordUtil.hashPassword(password, salt);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

            User updatedUser = User.newBuilder()
                    .id(user.getId())
                    .login(user.getLogin())
                    .password(newPassword)
                    .salt(salt)
                    .name(user.getName())
                    .isAdmin(user.isAdmin())
                    .build();

            userDao.update(updatedUser);

            resp.sendRedirect("/login");
        }
    }
}
