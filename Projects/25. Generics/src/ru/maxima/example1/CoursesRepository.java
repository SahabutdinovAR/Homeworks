package ru.maxima.example1;

import java.time.LocalDate;

/**
 * 20.07.2021
 * 25. Generics
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class CoursesRepository {
    private static final int MAX_COURSES_SIZE = 10;

    private Course[] courses;

    private int count;

    public CoursesRepository() {
        this.courses = new Course[MAX_COURSES_SIZE];
        this.count = 0;
    }

    public void save(Course course) {
        // TODO: проверить размерность
        this.courses[count] = course;
        count++;
    }

    // теперь данный код никогда не вернет null, он возвращает всегда объект Nullable
    // у которого есть value, в котором лежит либо объект, либо null
    public Nullable<Course> findFirstCourseAfterDate(LocalDate date) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getFrom().isAfter(date)) {
                return Nullable.of(courses[i]);
            }
        }
        return Nullable.empty();
    }
}
