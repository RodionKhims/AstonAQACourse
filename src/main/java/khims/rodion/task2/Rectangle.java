package khims.rodion.task2;

public class Rectangle extends BorderedShape {
    private final int a;
    private final int b;

    public Rectangle(String borderColor, String fillColor, int a, int b) {
        super(borderColor, fillColor);
        this.a = a;
        this.b = b;
    }

    @Override
    public double calcP() {
        return a + a + b + b;
    }

    @Override
    public double calcS() {
        return a * b;
    }
}
