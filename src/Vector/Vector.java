package Vector;

import java.util.Arrays;

public final class Vector {

    private int d;
    private double[] data;

    //конструктор 1
    public Vector(int d) {
        this.d = d;
        data = new double[d];
    }

    //конструктор 2
    public Vector(double... a) {
        d = a.length;
        data = new double[d];
        for (int i = 0; i < d; i++)
            data[i] = a[i];
    }

    //размер
    public int size() {
        return d;
    }

    public Vector sum(Vector that) {
        if (this.d != that.d) throw new IllegalArgumentException("Different sizes");
        Vector c = new Vector(d);
        for (int i = 0; i < d; i++)
            c.data[i] = this.data[i] + that.data[i];
        return c;
    }

    public Vector difference(Vector that) {
        if (this.d != that.d) throw new IllegalArgumentException("Different sizes");
        Vector c = new Vector(d);
        for (int i = 0; i < d; i++)
            c.data[i] = this.data[i] - that.data[i];
        return c;
    }

    public Vector multiplication(double alpha) {
        Vector c = new Vector(d);
        for (int i = 0; i < d; i++)
            c.data[i] = alpha * data[i];
        return c;
    }

    public Vector division(double beta) {
        Vector c = new Vector(d);
        for (int i = 0; i < d; i++)
            c.data[i] = data[i] / beta;
        return c;
    }

    public double module() {
        double sum = 0.0;
        for (int i = 0; i < d; i++)
            sum += (this.data[i] * this.data[i]);
        return Math.sqrt(sum);
    }

    public double scalarProduct(Vector that) {
        if (this.d != that.d) throw new IllegalArgumentException("Different sizes");
        double sum = 0.0;
        for (int i = 0; i < d; i++) {
            sum += (this.data[i] * this.data[i]);
        }
        return sum;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < d; i++)
            s.append(data[i] + " ");
        return s.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        if (d != vector.d) return false;
        return Arrays.equals(data, vector.data);
    }

    @Override
    public int hashCode() {
        int result = d;
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}
