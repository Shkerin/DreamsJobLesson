package com.vladshkerin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * TODO: comment
 *
 * @author Vladimir Shkerin
 * @since 13.03.2016
 */
public class EchoServlet extends HttpServlet {
    List<User> users = new ArrayList<User>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        StringBuilder sb = new StringBuilder();
        sb.append("<h3>List users: </h3>");
        for (User user : users)
            sb.append(user).append("<br>");

        resp.getWriter().write(sb.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Float fl = Float.parseFloat(req.getParameter("fl"));
        String[] children = req.getParameterValues("children");
        Calendar birthDay = Calendar.getInstance();
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            Date date = format.parse(req.getParameter("birthDay"));
            birthDay.setTime(date);
        } catch (ParseException e) {
            //TODO empty
        }
        users.add(new User(id, name, fl, birthDay, children));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int index = findIdById(id);
        if (index > -1)
            users.set(index, new User(id, name));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        int index = findIdById(id);
        if (index > -1)
            users.remove(index);
    }

    /**
     * Search by field "id" in the collection User.
     *
     * @param id the value of the unique field "id" in collection
     * @return -1 if element do not find,
     * index element in the collection
     */
    private int findIdById(Integer id) {
        int index = -1;
        for (User user : users) {
            if (user.getId().equals(id)) {
                index = users.indexOf(user);
                break;
            }
        }
        return index;
    }
}
