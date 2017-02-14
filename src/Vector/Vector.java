package Vector;

public final class Vector {

    private final int x;                       //здесь точно будет int?
    private final int y;
    private final int z;

    public Vector(int x, int y, int z) {        //по-твоему это всё??
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector sum(Vector other) {
        return new Vector(
                x + other.x,
                y + other.y,
                z + other.z
        );
    }

    public Vector difference(Vector other) {
        return new Vector(
                x - other.x,
                y - other.y,
                z - other.z
        );
    }

    public Vector multiplication(int k) {
        return new Vector(
                k*x,
                k*y,
                k*z
        );
    }

    public Vector division(int k) {
        return new Vector(
                x/k,                             //может получиться не int, подумать
                y/k,
                z/k
        );
    }

    public Vector scalarProduct(Vector other, ) {

    }

}
