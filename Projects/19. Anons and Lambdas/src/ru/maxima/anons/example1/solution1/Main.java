package ru.maxima.anons.example1.solution1;

import ru.maxima.anons.example1.Document;

public class Main {

    public static void main(String[] args) {
	    Document d1 = new Document(134000232);
	    Document d2 = new Document(234312490);
	    Document d3 = new Document(78273823);
	    Document d4 = new Document(43878100);
	    Document d5 = new Document(1232198);
	    Document d6 = new Document(34238989);

	    DocumentsAbbreviatedProcessor processor = new DocumentsAbbreviatedProcessor();

	    processor.process(d1);
	    processor.process(d2);
	    processor.process(d3);
	    processor.process(d4);
	    processor.process(d5);
	    processor.process(d6);

	    processor.printDocuments();

	    DocumentsRemoveUnnecessaryProcessor processor1 = new DocumentsRemoveUnnecessaryProcessor();
	    processor1.process(d1);
	    processor1.process(d2);
	    processor1.process(d3);
	    processor1.process(d4);
	    processor1.process(d5);
	    processor1.process(d6);
	    processor1.printDocuments();
    }
}
