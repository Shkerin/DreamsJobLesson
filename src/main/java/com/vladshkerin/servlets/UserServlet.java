package com.vladshkerin.servlets;

import com.vladshkerin.models.User;
import com.vladshkerin.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO: comment
 *
 * @author Vladimir Shkerin
 * @since 13.03.2016
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        if (id != null && name != null) {
            UserService.getInstance().add(new User(id, name));
        }
        req.setAttribute("role", "role_admin");
        req.getRequestDispatcher(String.format("%s/views/UserView.jsp", req.getContextPath())).forward(req, resp);
    }
}
