public class A {
    protected int x, y;
    private int z;

    public A(int a, int b, int c) {
        this.x = a;
        this.y = b;
        this.z = c;
    }

    public int GetZ() {
        return this.z;
    }

    public int GetX() {
        return this.x;
    }

    public int GetY() {
        return this.y;
    }

    public void SetX(int x) {
        this.x = x;
    }

    public void SetY(int y) {
        this.y = y;
    }

    public void SetZ(int z) {
        this.z = z;
    }
}
