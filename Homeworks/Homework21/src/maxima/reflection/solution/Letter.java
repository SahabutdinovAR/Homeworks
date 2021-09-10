package maxima.reflection.solution;

import maxima.reflection.framework.Document;

import java.util.StringJoiner;

/**
 * 02.09.2021
 * 35. Reflection
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Letter implements Document {
    private String from;
    private String to;

    public Letter(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Letter.class.getSimpleName() + "[", "]")
                .add("from='" + from + "'")
                .add("to='" + to + "'")
                .toString();
    }
}
