package com.epam.students.servlet;

import com.epam.students.dao.UserDao;
import com.epam.students.model.User;
import com.epam.students.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import static com.epam.students.servlet.Language.language;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private HttpSession session;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("email");
        String password = request.getParameter("pass");

        UserService userService = new UserService();
        User user = userService.checkUser(login, password);
        if (user != null) {

            int id = user.getId();
            String userName = user.getName();

            Cookie cookieUserName = new Cookie("user", userName);
            cookieUserName.setMaxAge(60 * 30);
            response.addCookie(cookieUserName);

            Cookie cookieUserId = new Cookie("userId", String.valueOf(id));
            cookieUserId.setMaxAge(60 * 30);
            response.addCookie(cookieUserId);

            session = request.getSession(true);
            session.setAttribute("userId", id);
            session.setAttribute("userName", userName);
            session.setAttribute("userIsAdmin", user.isAdmin());
            session.setAttribute("language", language);

            redirectUser(response, user);

        } else {
            request.setAttribute("error", login);
            request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    private void redirectUser(HttpServletResponse response, User user) throws IOException {
        if (user.isAdmin() == 1) {
            response.sendRedirect("/adminpage");
        } else {
            response.sendRedirect("/page?num=1");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        UserDao userDao = new UserDao();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    session = req.getSession(true);
                    session.setAttribute("userName", cookie.getValue());
                }
            }

            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userId")) {
                    int id = Integer.parseInt(cookie.getValue());
                    User user = userDao.read(id);
                    session.setAttribute("userIsAdmin", user.isAdmin());
                    redirectUser(resp, user);
                    return;
                }
            }
        }

        req.getSession().setAttribute("language", language);
        req.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }

}
