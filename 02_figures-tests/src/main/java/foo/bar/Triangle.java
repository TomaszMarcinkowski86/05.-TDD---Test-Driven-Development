package foo.bar;

public class Triangle implements Figure {

private int a;
private int h;

    public Triangle(int a, int h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public int area() {
        return 0;
    }

    @Override
    public int circumference() {
        return 0;
    }
}
