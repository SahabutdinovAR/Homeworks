package ru.maxima.blacklist;

/**
 * 06.09.2021
 * 36. Spring Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface PasswordBlackList {
    public boolean contains(String password);
}
