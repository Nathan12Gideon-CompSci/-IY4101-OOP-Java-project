import java.lang.Math;
public class Circle extends Shape {

    private int radius;

    public Circle(Coordinates position, int radius) {
        super(0, position);
        this.radius = radius;
    }

    @Override
    public double getArea() { return Math.PI * radius * radius; }

    @Override
    public double getPerimeter() { return 2 * Math.PI * radius; }

    @Override
    public void scale(int factor, boolean sign) {
        if (sign) radius *= factor;
        else if (factor != 0) radius /= factor;
    }

    @Override
    public String display() {
        return "Circle at (" + position.getX() + "," + position.getY() + 
               ") | Radius: " + radius + " | Area: " + String.format("%.2f", getArea());
    }
}
