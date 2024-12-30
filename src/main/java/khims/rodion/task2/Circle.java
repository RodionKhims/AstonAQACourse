package khims.rodion.task2;

public class Circle extends BorderedShape {
    private final int radius;

    public Circle(String borderColor, String fillColor, int radius) {
        super(borderColor, fillColor);
        this.radius = radius;
    }

    @Override
    public double calcP() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calcS() {
        return Math.PI * radius * radius;
    }
}
