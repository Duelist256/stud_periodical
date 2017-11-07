package com.epam.students.filter;

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

@WebFilter("/*")
public class CheckFilter implements Filter {

    private final static Logger logger = Logger.getLogger(CheckFilter.class);

    public void destroy() {
    }

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

        boolean isUserNotAdmin = isUserNotAdmin(request.getCookies());

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
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userIsAdmin")) {
                    if (Integer.parseInt(cookie.getValue()) == 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
