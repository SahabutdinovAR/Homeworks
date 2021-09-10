package maxima.reflection.solution;

import maxima.reflection.solution.framework.DefaultValue;
import maxima.reflection.solution.framework.Document;

import java.time.LocalDate;
import java.util.StringJoiner;

/**
 * 02.09.2021
 * 35. Reflection
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Act implements Document {
    private LocalDate date;
    private String name;
    private String description;
    // здесь значение должно проставляться автоматически
    @DefaultValue(value = "ОБЭП")
    private String from;

    public Act(LocalDate date, String name, String description) {
        this.date = date;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Act.class.getSimpleName() + "[", "]")
                .add("date=" + date)
                .add("name='" + name + "'")
                .add("description='" + description + "'")
                .add("from='" + from + "'")
                .toString();
    }
}
