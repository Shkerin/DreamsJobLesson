package com.vladshkerin.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO: comment
 *
 * @author Vladimir Shkerin
 * @since 24.03.2016
 */
public class LoginServlet extends HttpServlet {

    private final Map<String, String> credentials = new ConcurrentHashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();
        this.credentials.put("root", "root");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(Integer.MAX_VALUE);
        synchronized (session) {
            if (this.credentials.containsKey(login) && password.equals(this.credentials.get(login))) {
                session.setAttribute("login", login);
                session.setAttribute("password", password);
                req.getRequestDispatcher("/WEB-INF/views/Main.jsp").forward(req, resp);
            } else {
                req.setAttribute("error.login", "Invalid login or  password credentials!");
                req.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(req, resp);
            }
        }
    }
}
