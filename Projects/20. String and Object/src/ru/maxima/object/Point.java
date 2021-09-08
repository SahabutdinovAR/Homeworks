package ru.maxima.object;

/**
 * 02.07.2021
 * 20. String and Object
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Point {
    private int x;
    private int y;
    private int z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public boolean equals(Object object) {
        // если object указывает не на Point
        if (!(object instanceof Point)) {
            // сразу говорим, что объекты не эквивалентны
            return false;
        }

        if (this == object) {
            return true;
        }

        // instanceof вернет false, если object -> null
//        if (object == null) {
//            return false;
//        }

        // сделали понижающее преобразование
        // поскольку мы знаем, что сравниваем точки, мы можем безболезненно сделать преобразование
        Point that = (Point)object;
        // теперь сравниваем значения полей объектов
        return this.x == that.x && this.y == that.y && this.z == that.z;
    }

//    public boolean equals(Point that) {
//
//        if (that == null) {
//            return false;
//        }
//
//        if (this == that) {
//            return true;
//        }
//
//        // теперь сравниваем значения полей объектов
//        return this.x == that.x && this.y == that.y && this.z == that.z;
//    }
}
