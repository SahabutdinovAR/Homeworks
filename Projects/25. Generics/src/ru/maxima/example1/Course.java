package ru.maxima.example1;

import java.time.LocalDate;
import java.util.StringJoiner;

/**
 * 20.07.2021
 * 25. Generics
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Course {
    private String title;
    private LocalDate from;
    private LocalDate to;

    public Course(String title, LocalDate from, LocalDate to) {
        this.title = title;
        this.from = from;
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Course.class.getSimpleName() + "[", "]")
                .add("title='" + title + "'")
                .add("from=" + from)
                .add("to=" + to)
                .toString();
    }
}
