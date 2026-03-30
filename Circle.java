import java.lang.Math; // Added for Math.PI and sqrt
public class Circle extends Shape { // by using the extends keyword, Circle inherits from Shape

    private int radius; // Circle has a radius field, that is specific to Circle and not shared with other shapes

    public Circle(Coordinates position, int radius) {
        super(0, position); // Call the superclass constructor with 0 sides for Circle
        this.radius = radius;// Initialize the radius field with the provided value
        //(w3schools, n.d.)
    }

    @Override //(zfm, 2011)
    public double getArea() { return Math.PI * radius * radius; } //Area of a circle : A = πr^2

    @Override
    public double getPerimeter() { return 2 * Math.PI * radius; } // Perimeter (circumference) of a circle : C = 2πr

    @Override
    public void scale(int factor, boolean sign) { // Scales the radius of the circle based on the factor and sign
        if (sign) radius *= factor; // If sign is true, the radius is multiplied by the factor to scale up
        else if (factor != 0) radius /= factor;// If sign is false and factor is not zero, the radius is divided by the factor to scale down, with a check to prevent division by zero
    }

    @Override
    public String display() { // Returns a string representation of the circle, including its position, radius, and area formatted to two decimal places for readability
        return "Circle at (" + position.getX() + "," + position.getY() +  
               ") | Radius: " + radius + " | Area: " + String.format("%.2f", getArea());
    }
}
