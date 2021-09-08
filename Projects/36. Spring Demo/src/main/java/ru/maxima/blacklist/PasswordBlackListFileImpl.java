package ru.maxima.blacklist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 06.09.2021
 * 36. Spring Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class PasswordBlackListFileImpl implements PasswordBlackList {

    private String fileName;

    public PasswordBlackListFileImpl(String fileName) {
        this.fileName = fileName;
    }

    public boolean contains(String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            if(reader.lines().anyMatch(line -> line.equals(password))) {
                System.err.println("Пароль найден в черном списке!");
                return true;
            } else return false;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
