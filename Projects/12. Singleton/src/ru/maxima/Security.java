package ru.maxima;

/**
 * 18.06.2021
 * 12. Singleton
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
// контекст безопасности - будет хранить пользователей, которые имеют доступ к системе
public class Security {
    //---
    private static Security instance;

    public static Security getInstance() {
        return instance;
    }

    static {
        instance = new Security();
    }

    private Security() {
        // зарезервировали место для хранения пользователей
        this.users = new User[MAX_USERS_COUNT];
        // начальное количество пользователей равно 0
        this.usersCount = 0;
    }
    //---

    // максимальное допустимое количество пользователей
    private final int MAX_USERS_COUNT = 5;
    // массив пользователей
    private User[] users;
    // текущее количество пользователей
    private int usersCount;

    // регистрация пользователя
    public void signUp(String email, String password) {
        // если есть место
        if (usersCount < MAX_USERS_COUNT) {
            // создаем пользователя по его данным
            User newUser = new User(email, password);
            // добавляем в массив
            this.users[usersCount] = newUser;
            // увеличиваем текущее количество пользователей
            usersCount++;
        } else {
            System.err.println("Превышено допустимое количество пользователей");
        }
    }
    // проверяем, есть ли пользователь в нашей системе
    public boolean checkUser(String email, String password) {
        // пробегаем по всем пользователям
        for (int i = 0; i < usersCount; i++) {
            // проверяем совпадение имени и пароля
            if (isCorrectCredentials(email, password, users[i])) {
                // если совпадение есть, то возвращаем успех
                return true;
            }
        }
        return false;
    }

    private boolean isCorrectCredentials(String email, String password, User user) {
        return user.getEmail().equals(email) && user.getPassword().equals(password);
    }
}
