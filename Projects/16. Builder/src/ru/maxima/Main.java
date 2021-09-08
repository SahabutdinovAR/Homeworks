package ru.maxima;

/**
 * 22.06.2021
 * 16. Builder
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        // User marsel = new User("Марсель", "Сидиков", 27, 1.85, true);
        User marsel = User.builder()
                .firstName("Марсель")
                .lastName("Сидиков")
                .age(27)
                .height(1.85)
                .isWorker(true)
                .build();

//        User aliya = new User("Алия", true);

        User aliya = User.builder()
                .firstName("Алия")
                .isWorker(true)
                .build();

//        User airat = new User("Айрат", "Мухутдинов");

        User airat = User.builder()
                .firstName("Айрат")
                .lastName("Мухутдинов")
                .build();
    }
}
