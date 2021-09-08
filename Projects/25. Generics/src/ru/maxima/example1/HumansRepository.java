package ru.maxima.example1;

/**
 * 20.07.2021
 * 25. Generics
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class HumansRepository {
    private static final int MAX_HUMANS_SIZE = 10;

    private Human[] humans;

    private int count;

    public HumansRepository() {
        this.humans = new Human[MAX_HUMANS_SIZE];
        this.count = 0;
    }

    public void save(Human human) {
        // TODO: проверить размерность
        this.humans[count] = human;
        count++;
    }

    // теперь данный код никогда не вернет null, он возвращает всегда объект Nullable
    // у которого есть value, в котором лежит либо объект, либо null
    public Nullable<Human> findByName(String name) {
        for (int i = 0; i < count; i++) {
            if (humans[i].getName().equals(name)) {
                return Nullable.of(humans[i]);
            }
        }
        return Nullable.empty();
    }
}
