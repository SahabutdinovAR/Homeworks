package ru.maxima;

/**
 * 27.06.2021
 * 17. Inheritance and Polymorphism
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Work {
    public void doWork(Worker[] workers) {
        for (int i = 0; i < workers.length; i++) {
            workers[i].work();
        }
    }

    public void giveSalary(Worker[] workers) {
        for (int i = 0; i < workers.length; i++) {
            workers[i].getSalary();
        }
    }

    public void giveBenefits(Beneficiary[] beneficiaries) {
        for (int i = 0; i < beneficiaries.length; i++) {
            beneficiaries[i].getBenefit();
        }
    }
}
