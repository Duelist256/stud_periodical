package com.epam.students.filter;

import com.epam.students.dao.UserDao;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Defines admission rights for different kinds of users.
 * Equality? Never heard!
 */
@WebFilter("/*")
public class CheckFilter implements Filter {

    private final static Logger logger = Logger.getLogger(CheckFilter.class);

    @Override
    public void destroy() {
    }

    /**
     * Restricts unauthorized users' access to most pages except for login, registration and error pages.
     * Makes admin page accessible only for admins.
     *
     * @param req for http-request
     * @param resp for http-respond
     * @param chain for implementing sequence of filters
     * @throws ServletException from doFilter method
     * @throws IOException  from redirect and doFilter methods
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession(false);

        boolean loggedIn = session != null && session.getAttribute("userName") != null;

        String requestURI = request.getRequestURI();
        String loginURI = request.getContextPath() + "/login";

        logger.info("Request URI: " + requestURI);

        Set<String> necessaryPages = new HashSet<>();
        necessaryPages.add(loginURI);
        necessaryPages.add("/register.jsp");
        necessaryPages.add("/register");
        necessaryPages.add("/resetPassword");
        necessaryPages.add("/language");
        necessaryPages.add("/403.html");
        necessaryPages.add("/404.html");
        necessaryPages.add("/500.html");

        Cookie[] cookies = request.getCookies();
        boolean isUserNotAdmin = cookies == null || isUserNotAdmin(cookies);

        Set<String> adminPages = new HashSet<>();
        adminPages.add("/adminpage");
        adminPages.add("/adminPage.jsp");
        adminPages.add("/periodicalForm.jsp");

        if (loggedIn || necessaryPages.contains(requestURI)
                || requestURI.matches(".*(css|jpg|png|gif|js|ico)")) {

            if (isUserNotAdmin && adminPages.contains(requestURI)) {
                response.sendRedirect("/issue.jsp");
            } else {
                chain.doFilter(request, response);
            }

        } else {
            response.sendRedirect(loginURI);
        }
    }

    private boolean isUserNotAdmin(Cookie[] cookies) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId")) {
                int id = Integer.parseInt(cookie.getValue());
                UserDao userDao = new UserDao();
                int admin = userDao.read(id).isAdmin();
                return admin == 0;
            }
        }
        return true;
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}