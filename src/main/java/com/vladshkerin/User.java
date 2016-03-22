package com.vladshkerin;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

/**
 * Class to store the users id and name.
 */
public class User {
    private Integer id;
    private String name;
    private Float fl;
    private Calendar birthDay;
    private String[] children;

    public User(String name) {
        this.id = Math.abs(name.hashCode());
        this.name = name;
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(Integer id, String name, Float fl, Calendar birthDay, String[] children) {
        this.id = id;
        this.name = name;
        this.fl = fl;
        this.birthDay = birthDay;
        this.children = children;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        String strBirthDay = format.format(birthDay.getTime());

        StringBuilder sbChildren = new StringBuilder();
        sbChildren.append("[");
        for (String child : children)
            sbChildren.append(child).append(",");
        sbChildren.deleteCharAt(sbChildren.length() - 1).append("]");

        return getClass().getName()
                + "[id=" + id
                + ",name=" + name
                + ",fl=" + fl
                + ",birthDay=" + strBirthDay
                + ",children=" + sbChildren
                + "]";
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;

        User other = (User) otherObject;
        return Objects.equals(id, other.id) &&
                Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return 8 * id + name.hashCode();
//        return Objects.hash(id, name);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getFl() {
        return fl;
    }

    public void setFl(Float fl) {
        this.fl = fl;
    }

    public Calendar getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Calendar birthDay) {
        this.birthDay = birthDay;
    }

    public String[] getChildren() {
        return children;
    }

    public void setChildren(String[] children) {
        this.children = children;
    }
}
