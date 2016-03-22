package com.vladshkerin;

/**
 * TODO: comment
 *
 * @author Vladimir Shkerin
 * @since 22.03.2016
 */

public class SecurityContextHolder {

    private static final ThreadLocal<Integer> threadLocalCount = new ThreadLocal<Integer>();

    public static final Integer getCount() {
        return threadLocalCount.get();
    }

    public static final void setCount(Integer count) {
        threadLocalCount.set(++count);
    }
}
