package khims.rodion.task2;

public abstract class BorderedShape implements Shape {
    private final String borderColor;
    private final String fillColor;

    public BorderedShape(String borderColor, String fillColor) {
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public String getFillColor() {
        return fillColor;
    }
}
