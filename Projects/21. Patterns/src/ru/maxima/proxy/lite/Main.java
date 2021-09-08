package ru.maxima.proxy.lite;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Driver marsel = new Driver("Марсель");

        Driver airat = new Driver("Айрат");

        DriverProxy airatProxy = new DriverProxy(airat);
        airatProxy.setBefore(() -> System.out.println("Айрат, пожалуйста аккуратнее езжай!"));
        airatProxy.setInstead(() -> System.out.println("Нет бензина!"));
        airatProxy.setAfter(() -> System.out.println("Ура, мы приехали!"));

        Driver victor = new Driver("Виктор");

        TaxiService service = new TaxiService();
        service.setOnLine(new Driver[]{marsel, airatProxy, victor});
    }
}
