package com.epam.students.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class CheckFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession(false);

        boolean loggedIn = session != null && session.getAttribute("userName") != null;

        String requestURI = request.getRequestURI();
        String loginURI = request.getContextPath() + "/login";
        boolean loginRequest = requestURI.equals(loginURI);

        System.out.println(requestURI);
        boolean register = requestURI.equals("/register.jsp") || requestURI.equals("/register");
        boolean resetPassword = requestURI.equals("/resetPassword");
        boolean languageRequest = requestURI.equals("/language");

        if (loggedIn || loginRequest || register || resetPassword || languageRequest
                || requestURI.matches(".*(css|jpg|png|gif|js|ico)")) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
