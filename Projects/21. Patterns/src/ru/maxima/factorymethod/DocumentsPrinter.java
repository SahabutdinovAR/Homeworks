package ru.maxima.factorymethod;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class DocumentsPrinter {
    private DocumentsGenerator documentsGenerator;

    public void setDocumentsGenerator(DocumentsGenerator documentsGenerator) {
        this.documentsGenerator = documentsGenerator;
    }

    public void printDocument(String text) {
        Document document = documentsGenerator.generate(text);
        System.out.println("----" + document.getTitle() + "----");
        System.out.println(document.getText());
    }
}
