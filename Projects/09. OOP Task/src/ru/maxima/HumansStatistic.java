package ru.maxima;

/**
 * 16.06.2021
 * 09. OOP Task
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class HumansStatistic {
    int[] calcAgesStatistic(Human[] humans, int maxAge) {
        int ages[] = new int[maxAge];

        for (int i = 0; i < humans.length; i++) {
//            int currentAge = humans[i].age;
            int currentAge = humans[i].getAge();
            ages[currentAge]++;
        }

        return ages;
    }
}
