package ru.maxima.example1;

import java.time.LocalDate;

/**
 * 20.07.2021
 * 25. Generics
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        HumansRepository humansRepository = new HumansRepository();
        CoursesRepository coursesRepository = new CoursesRepository();

        Human marsel = new Human("Марсель", 27);
        Human airat = new Human("Айрат", 22);
        Human maxim = new Human("Максим", 21);
        Human daniil = new Human("Даниил", 21);

        Course java = new Course("Java", LocalDate.of(2021, 2, 2),
                LocalDate.of(2021, 12, 31));

        Course sql = new Course("SQL", LocalDate.of(2021, 6, 30),
                LocalDate.of(2021, 12, 31));

        Course php = new Course("PHP", LocalDate.of(2021, 3, 5),
                LocalDate.of(2021, 12, 31));

        Course python = new Course("Python", LocalDate.of(2021, 7, 10),
                LocalDate.of(2021, 12, 31));

        humansRepository.save(marsel);
        humansRepository.save(airat);
        humansRepository.save(maxim);
        humansRepository.save(daniil);

        coursesRepository.save(java);
        coursesRepository.save(sql);
        coursesRepository.save(php);
        coursesRepository.save(python);

        Nullable<Human> nullableDaniil = humansRepository.findByName("Игорь");

        if (nullableDaniil.isPresent()) {
            Human daniilFromRepository = nullableDaniil.get();
            System.out.println(daniilFromRepository.getAge());
        } else {
            System.out.println("Нет такого пользователя");
        }

        Nullable<Course> nullableSQl = coursesRepository
                .findFirstCourseAfterDate(LocalDate.of(2021, 5, 31));

        // компилятор проверяет, как был объявлен метод findByName, там указано, что возвращается
        // Nullable<Human>, здесь же это значение присваивается Nullable<Course> и программа не может быть
        // скомпилирована
        // Nullable<Course> nullableSQl = humansRepository.findByName("Марсель");

        if (nullableSQl.isPresent()) {
            // почему нет явного преобразования?
            // потому что компилятор смотрит, как был объявлен nullableSql
            // он был объявлен как Nullable<Course>, следовательно его метод T get()
            // рассматривается как Course get()
            // поскольку компилятор выполняет все проверки, то гарантируется что nullableSql точно лежит курс
            Course sqlFromRepository = nullableSQl.get();
            System.out.println(sqlFromRepository);
        } else {
            System.out.println("Таких курсов нет");
        }
    }
}
