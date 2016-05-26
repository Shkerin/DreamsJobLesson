package com.vladshkerin.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO: comment
 *
 * @author Vladimir Shkerin
 * @since 28.03.2016
 */
public class ColorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("color", req.getParameter("color"));
        cookie.setMaxAge(Integer.MAX_VALUE);
        resp.addCookie(cookie);

        req.getRequestDispatcher("/user").forward(req, resp);
    }
}
