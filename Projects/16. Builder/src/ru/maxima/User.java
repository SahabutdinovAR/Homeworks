package ru.maxima;

/**
 * 22.06.2021
 * 16. Builder
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class User {
    private String firstName; // если ничего не кладем - null
    private String lastName; // null
    private int age; // 0
    private double height; // 0.0
    private boolean isWorker; // false

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.height = builder.height;
        this.isWorker = builder.isWorker;
    }

    public static class UserBuilder {

        private String firstName;
        private String lastName;
        private int age;
        private double height;
        private boolean isWorker;

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder height(double height) {
            this.height = height;
            return this;
        }

        public UserBuilder isWorker(boolean isWorker) {
            this.isWorker = isWorker;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }
}
