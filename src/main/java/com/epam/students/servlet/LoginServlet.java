package com.epam.students.servlet;

import com.epam.students.dao.UserDao;
import com.epam.students.model.User;
import com.epam.students.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static String language = "ru";

    public static String getLanguage() {
        return language;
    }

    public static void setLanguage(String language) {
        LoginServlet.language = language;
    }

    private Cookie cookieUserName;
    private Cookie cookieUserId;
    private HttpSession session;
    private HttpSession sessionLanguage;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("email");
        String password = request.getParameter("pass");

        UserService userService = new UserService();
        User user = userService.checkUser(login, password);
        if (user != null) {

            String name = user.getName();

            cookieUserName = new Cookie("user", name);
            cookieUserName.setMaxAge(60 * 5); //5 mins
            response.addCookie(cookieUserName);

            cookieUserId = new Cookie("userId", String.valueOf(user.getId()));
            cookieUserId.setMaxAge(60 * 5); //5 mins
            response.addCookie(cookieUserId);

            session = request.getSession(true);
            session.setAttribute("userName", name);

            sessionLanguage = request.getSession(true);
            sessionLanguage.setAttribute(language, getLanguage());

            redirectUser(response, user);

        } else {
            request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    private void redirectUser(HttpServletResponse response, User user) throws IOException {
        if (user.isAdmin() == 1) {
            response.sendRedirect("/adminpage");
        } else {
            response.sendRedirect(" /page?num=1");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
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
                    User user = new UserDao().read(id);
                    redirectUser(resp, user);
                    return;
                }
            }
        }

        req.getSession().setAttribute("language", getLanguage());
        req.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }

}
