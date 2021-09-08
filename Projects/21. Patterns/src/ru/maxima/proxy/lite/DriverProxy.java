package ru.maxima.proxy.lite;

/**
 * 06.07.2021
 * 21. Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class DriverProxy extends Driver {

    private Driver driver;

    private After after;
    private Instead instead;
    private Before before;

    public DriverProxy(Driver driver) {
        super(driver.getName());
        this.driver = driver;
    }

    @Override
    public void drive() {
        // поведение до вызова, может быть вызвано всегда когда она есть
        if (before != null) {
            before.before();
        }

        // instead - вместо, т.е. мы вызываем поведение instead вместо drive
        if (instead != null) {
            instead.instead();
        } else {
            driver.drive();
        }

        if (after != null) {
            after.after();
        }
    }

    public void setAfter(After after) {
        this.after = after;
    }

    public void setInstead(Instead instead) {
        this.instead = instead;
    }

    public void setBefore(Before before) {
        this.before = before;
    }
}
