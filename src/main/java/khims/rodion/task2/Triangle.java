package khims.rodion.task2;

public class Triangle extends BorderedShape {
    private final int a;
    private final int b;
    private final int c;

    public Triangle(String borderColor, String fillColor, int a, int b, int c) {
        super(borderColor, fillColor);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calcP() {
        return a + b + c;
    }

    @Override
    public double calcS() {
        double p = calcP() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
