package com.vladshkerin.services;

import com.vladshkerin.models.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * TODO: comment
 *
 * @author Vladimir Shkerin
 * @since 13.03.2016
 */
public class UserService {

    private static final UserService instance = new UserService();

    private final List<User> users = new CopyOnWriteArrayList<>();

    private UserService() {
        users.add(new User("1", "Make"));
        users.add(new User("2", "Ivan"));
        users.add(new User("3", "Petr"));
    }

    public static UserService getInstance() {
        return instance;
    }

    public List<User> getAll() {
        return this.users;
    }

    public User getById(String id) {
        for (User user: this.users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        throw new IllegalArgumentException(String.format("Not found user with id %s", id));
    }

    public void add(final User user) {
        this.users.add(user);
    }
}
