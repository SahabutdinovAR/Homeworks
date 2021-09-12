package ru.maxima;

import java.util.Arrays;
import java.util.List;

public class PasswordBlackListHardcode implements PasswordBlackList {
    private static List<String> blacklist = Arrays.asList("qwerty", "12345", "abcd", "007");

    public boolean contains(String password) {
        if (blacklist.contains(password)) {
            System.err.println("Пароль найден в черном списке!");
            return true;
        } else return false;
    }
}


