package com.eclipseeio.emi.service;

public class TextUtils {

    public static boolean isEmpty(String name) {
        return name == null || name.trim().length() == 0;
    }
}
