package ru.maxima.blacklist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PasswordBlackListFileImpl implements PasswordBlackList {
    private String fileName;


    public PasswordBlackListFileImpl(String file_name) {
        this.fileName = fileName;
    }


    public boolean contains(String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
           if(reader.lines().anyMatch(line->line.equals(password))) {
               System.err.println("Пароль найден в черном списке");
               return true;
           }else return false;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}







