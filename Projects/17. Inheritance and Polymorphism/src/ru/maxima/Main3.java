package ru.maxima;

/**
 * 27.06.2021
 * 17. Inheritance and Polymorphism
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main3 {
    public static void main(String[] args) {
        Athlete bolt = new Athlete("Усейн Болт", 35, 10);
        Workman marsel = new Workman("Марсель", 27, 10);
        Student maxim = new Student("Максим", 22, 4.5);

        Worker[] workers = {bolt, marsel};
        Beneficiary[] beneficiaries = {bolt, maxim};

        Work work = new Work();
        work.doWork(workers);
        work.giveSalary(workers);
        work.giveBenefits(beneficiaries);
    }
}
