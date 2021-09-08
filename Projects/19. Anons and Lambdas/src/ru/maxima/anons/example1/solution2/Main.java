package ru.maxima.anons.example1.solution2;

import ru.maxima.anons.example1.AbstractDocumentsProcessor;
import ru.maxima.anons.example1.Document;

public class Main {

    public static void main(String[] args) {
	    Document d1 = new Document(134000232);
	    Document d2 = new Document(234312490);
	    Document d3 = new Document(78273823);
	    Document d4 = new Document(43878100);
	    Document d5 = new Document(1232198);
	    Document d6 = new Document(34238989);

	    // анонимный класс
		// возможно объявление внутри другого метода или класса в качестве поля
		// логика нереализованных (абстрактных) методов должна быть описана прямо здесь
		// создается единственный объект
		// почему применили?
		// если логика нигде кроме этого места не используется - можно использовать анонимный класс
		AbstractDocumentsProcessor abbreviatedProcessor = new AbstractDocumentsProcessor() {
			@Override
			public Document processingLogic(Document document) {
				return new Document(document.getValue() % 1000);
			}
		};

		AbstractDocumentsProcessor removeUnnecessaryProcessor = new AbstractDocumentsProcessor() {
			@Override
			public Document processingLogic(Document document) {
				// удаляем нули из числа
				int value = document.getValue();
				int newValue = 0;

				while (value != 0) {
					int digit = value % 10;
					if (digit != 0) {
						newValue = newValue + digit;
						newValue = newValue * 10;
					}
					value = value / 10;
				}

				return new Document(newValue / 10);
			}
		};

		abbreviatedProcessor.process(d1);
		abbreviatedProcessor.process(d2);
		abbreviatedProcessor.process(d3);
		abbreviatedProcessor.process(d4);
		abbreviatedProcessor.process(d5);
		abbreviatedProcessor.process(d6);

		abbreviatedProcessor.printDocuments();

		removeUnnecessaryProcessor.process(d1);
		removeUnnecessaryProcessor.process(d2);
		removeUnnecessaryProcessor.process(d3);
		removeUnnecessaryProcessor.process(d4);
		removeUnnecessaryProcessor.process(d5);
		removeUnnecessaryProcessor.process(d6);

		removeUnnecessaryProcessor.printDocuments();
    }
}
