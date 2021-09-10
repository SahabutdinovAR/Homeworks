package maxima.reflection.solution;

import maxima.reflection.solution.framework.DocumentsFramework;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        DocumentsFramework framework = new DocumentsFramework();
        Statement statement = framework.generate(Statement.class, "Сидиков Марсель",
                LocalDate.of(1994, 2, 2));

        Statement statement1 = framework.generate(Statement.class, "Сидиков Марсель");

       Letter letter = framework.generate(Letter.class, "Марсель", "Айрат");
        System.out.println(statement);
        System.out.println(statement1);
        System.out.println(letter);
    }

    private static class Statement {
    }
}
