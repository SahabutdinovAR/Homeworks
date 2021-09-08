package ru.maxima.blacklist;

import java.util.Arrays;
import java.util.List;

/**
 * 06.09.2021
 * 36. Spring Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class PasswordBlackListHardcodeImpl implements  PasswordBlackList {

    private static List<String> blacklist = Arrays.asList("qwerty", "12345", "abcd", "007");

    public boolean contains(String password) {
        if (blacklist.contains(password)) {
            System.err.println("Пароль найден в черном списке!");
            return true;
        } else {
            return false;
        }
    }
}
