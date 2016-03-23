package com.vladshkerin.models;

/**
 * TODO: comment
 *
 * @author Vladimir Shkerin
 * @since 13.03.2016
 */
public class User {

    private final String id;
    private final String login;

    public User(final String id, final String login) {
        this.id = id;
        this.login = login;
    }

    public String getId() {
        return this.id;
    }

    public String getLogin() {
        return this.login;
    }
}
