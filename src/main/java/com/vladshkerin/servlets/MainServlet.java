package com.vladshkerin.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * TODO: comment
 *
 * @author Vladimir Shkerin
 * @since 26.05.2016
 */
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session == null || session.getAttribute("login") == null) {
            req.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/views/Main.jsp").forward(req, resp);
        }
    }
}
