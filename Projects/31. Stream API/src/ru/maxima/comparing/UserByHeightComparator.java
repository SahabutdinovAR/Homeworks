package ru.maxima.comparing;

import ru.maxima.User;

import java.util.Comparator;

/**
 * 14.08.2021
 * 31. Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UserByHeightComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        // 1.85 - 1.73 = 0.12 -> 0
//        return (int)(o1.getHeight() - o2.getHeight());
        return Double.compare(o1.getHeight(), o2.getHeight());
    }
}
