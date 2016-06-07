package com.vladshkerin.servlets;

import com.vladshkerin.services.UserService;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * TODO: comment
 *
 * @author vlad
 * @since 07.06.2016
 */
public class UserServletTest {

    @Test
    public void whenRequestToUserServletThenAddNewUser() {
        UserServlet servlet = new UserServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher("/WEB-INF/views/UserView.jsp")).thenReturn(dispatcher);
        when(request.getParameter("id")).thenReturn("3");
        when(request.getParameter("name")).thenReturn("petr");


        try {
            servlet.doPost(null, null);
        } catch (ServletException | IOException e) {
            //
        }

        assertFalse(UserService.getInstance().getAll().isEmpty());
        assertEquals("petr", UserService.getInstance().getById("3").getLogin());
    }
}
