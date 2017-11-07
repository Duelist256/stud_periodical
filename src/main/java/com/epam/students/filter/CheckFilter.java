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

        String loginURI = request.getContextPath() + "/login";

        boolean loggedIn = session != null && session.getAttribute("userName") != null;
        String requestURI = request.getRequestURI();
        boolean loginRequest = requestURI.equals(loginURI);

        System.out.println(requestURI);

        boolean isBootstrap = "/css/bootstrap.css".equals(requestURI);
        boolean isStyle1 = "/css/style1.css".equals(requestURI);
        boolean firstImg = "/img/Russia.png".equals(requestURI);
        boolean secondImg = "/img/United-Kingdom.png".equals(requestURI);
        boolean favicon = "/favicon.ico".equals(requestURI);

        if (loggedIn || loginRequest
                || isBootstrap || isStyle1 || firstImg || secondImg || favicon) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
