package com.vladshkerin.servlets;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * TODO: comment
 *
 * @author vlad
 * @since 05.06.2016
 */
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter");

        HttpSession session = ((HttpServletRequest) request).getSession(false);
        HttpServletRequest req = ((HttpServletRequest) request);

        if (req.getRequestURI().contains("login")) {
            chain.doFilter(request, response);
        } else if (session == null || session.getAttribute("login") == null) {
            request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
