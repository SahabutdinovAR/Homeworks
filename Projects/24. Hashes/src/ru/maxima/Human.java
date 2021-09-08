package ru.maxima;

/**
 * 16.07.2021
 * 24. Hashes
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Human {
    private String firstName;
    private String lastName;
    private int age;
    private boolean isWorker;
    private double height;
    private char sex;

    public Human(String firstName, String lastName, int age, boolean isWorker, double height, char sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isWorker = isWorker;
        this.height = height;
        this.sex = sex;
    }

    @Override
    public int hashCode() {
        int[] hashes = new int[]{
                firstName.hashCode(),
                lastName.hashCode(),
                Integer.hashCode(age),
                Boolean.hashCode(isWorker),
                Double.hashCode(height),
                Character.hashCode(sex)};

        int h = 0;
        for (int i = 0; i < hashes.length; i++) {
            h += 31 * h + hashes[i];
        }

        return h;
    }
}
