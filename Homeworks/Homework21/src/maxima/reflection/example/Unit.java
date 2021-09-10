package maxima.reflection.example;

import java.util.StringJoiner;

public class Unit {
    private String name;
    private double hp;
    private double mana;

    public Unit() {
        this.name = "DEFAULT";
    }

    public Unit(String name, double hp, double mana) {
        this.name = name;
        this.hp = hp;
        this.mana = mana;
    }

    public Unit(String name) {
        this.name = name;
    }

    public void manaUp(double value) {
        this.mana += value;
    }

    private double privateMethod() {
        return -1;
    }

    public double damage() {
        return hp * mana;
    }

    public String getName() {
        return name;
    }

    public double getHp() {
        return hp;
    }

    public double getMana() {
        return mana;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Unit.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("hp=" + hp)
                .add("mana=" + mana)
                .toString();
    }
}
