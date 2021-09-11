package maxima.reflection.solution;

import maxima.reflection.framework.DefaultValue;
import maxima.reflection.framework.Document;

import java.time.LocalDate;
import java.util.StringJoiner;

/**
 * 02.09.2021
 * 35. Reflection
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Statement implements Document {
    private String name;
    private LocalDate birthDate;

    // значение должно проставляться автоматически
    @DefaultValue("ООО Зеленоглазое такси")
    private String company;

    @DefaultValue("123322389891")
    private String inn;

    public Statement(String name) {
        this.name = name;
    }

    public Statement(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Statement.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("birthDate=" + birthDate)
                .add("company='" + company + "'")
                .add("inn='" + inn + "'")
                .toString();
    }
}
