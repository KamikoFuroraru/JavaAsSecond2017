package Vector;

import java.util.Arrays;

/*
Класс хранит вектор произвольной размерности.
Методы: сложение и вычитание векторов, умножение и деление на число,
скалярное произведение векторов, вычисление модуля вектора.
Утилита: векторное произведение трёхмерных векторов.
 */

public final class Vector {

    private final int d;
    private final double[] data;

    //конструктор 1
    public Vector(final int d) {
        this.d = d;
        data = new double[d];
    }

    //конструктор 2
    public Vector(final double... a) {
        d = a.length;
        data = Arrays.copyOf(a, d);
    }

    //размер
    public int size() {
        return d;
    }

    public void sum(final Vector other) {
        if (this.d != other.d) throw new IllegalArgumentException("Different sizes");
        for (int i = 0; i < d; i++)
            this.data[i] += other.data[i];
    }

    public void difference(final Vector other) {
        if (this.d != other.d) throw new IllegalArgumentException("Different sizes");
        for (int i = 0; i < d; i++)
            this.data[i] -= other.data[i];
    }

    public void multiplication(final double alpha) {
        for (int i = 0; i < d; i++)
            data[i] *= alpha;
    }

    public void division(final double beta) {
        for (int i = 0; i < d; i++)
            data[i] /= beta;
    }

    public double scalarProduct(final Vector other) {
        if (this.d != other.d) throw new IllegalArgumentException("Different sizes");
        double sum = 0.0;
        for (int i = 0; i < d; i++) {
            sum += this.data[i] * other.data[i];
        }
        return sum;
    }

    public double module() {
        return Math.sqrt(scalarProduct(this));
    }

    public static Vector vectorProduct(final Vector a, final Vector b) {
        if (a.d != 3 && b.d != 3) throw new IllegalArgumentException();
        double newX = a.data[1] * b.data[2] - a.data[2] * b.data[1];
        double newY = a.data[2] * b.data[0] - a.data[0] * b.data[2];
        double newZ = a.data[0] * b.data[1] - a.data[1] * b.data[0];
        return new Vector(newX, newY, newZ);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("(");
        for (int i = 0; i < d; i++)
            s.append(data[i] + ", ");
        s.delete(s.length() - 2, s.length()).append(")");
        return s.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        return d == vector.d && Arrays.equals(data, vector.data);
    }

    @Override
    public int hashCode() {
        int result = d;
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}
