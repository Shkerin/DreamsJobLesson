package com.vladshkerin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: comment
 *
 * @author Vladimir Shkerin
 * @since 13.03.2016
 */
public class EchoServlet extends HttpServlet {
    List<Users> users = new ArrayList<Users>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        StringBuilder sb = new StringBuilder();
        sb.append("<h3>List users: </h3>");
        for (Users user : users)
            sb.append(user).append("<br>");

        resp.getWriter().write(sb.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String value = req.getParameter("name");
        users.add(new Users(value));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String index = req.getParameter("index");
        String name = req.getParameter("name");

        int id = findIdByIndex(index);
        if (id > -1)
            users.set(id, new Users(index, name));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String index = req.getParameter("index");
        users.remove(index);

        int id = findIdByIndex(index);
        if (id > -1)
            users.remove(id);
    }

    /**
     * Search by field "index" in the collection Users.
     *
     * @param index the value of the unique field "index" in collection
     * @return -1 if element do not find,
     *         index element in the collection
     */
    private int findIdByIndex(String index) {
        int id = -1;
        for (Users user : users) {
            if (user.id.equals(index)) {
                id = users.indexOf(user);
                break;
            }
        }
        return id;
    }

    private class Users {
        private String id;
        private String name;

        public Users(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public Users(String name) {
            this.id = String.valueOf(Math.abs(name.hashCode()));
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("%-10s : %s", id, name);
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
