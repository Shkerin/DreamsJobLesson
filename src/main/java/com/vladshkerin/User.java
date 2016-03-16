package com.vladshkerin;

import java.util.Objects;

/**
 * Class to store the users id and name.
 */
public class User {
    private String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name) {
        this.id = String.valueOf(Math.abs(name.hashCode()));
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%-10s : %s", id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        User other = (User) obj;
        return Objects.equals(id, other.id) &&
                Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
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
