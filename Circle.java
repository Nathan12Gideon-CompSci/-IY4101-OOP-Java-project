import java.lang.Math; // math class for area and perimeter calculations

public class Circle extends Shape {
    private int radius; // sets a private variable for the radius of the circle, which is specific to the Circle class and is used to calculate the area and perimeter of the circle.

    public Circle(Coordinates position, int radius) {
        super(0, position); // 0 sides for a circle
        this.radius = radius;// initializes the radius variable with the provided value. The constructor also calls the constructor of the superclass (Shape) using super() to initialize the sides variable with 0 (since a circle has no sides) and sets the position variable to the provided Coordinates object.
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }// the getArea() method calculates and returns the area of the circle using the formula A = πr^2, where r is the radius of the circle. It uses the Math.PI constant from the Math class to represent the value of π. This method overrides the abstract getArea() method defined in the Shape class, providing a specific implementation for calculating the area of a circle based on its radius.

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    } // the getPerimeter() method calculates and returns the perimeter (circumference) of the circle using the formula P = 2πr, where r is the radius of the circle. It uses the Math.PI constant from the Math class to represent the value of π. This method overrides the abstract getPerimeter() method defined in the Shape class, providing a specific implementation for calculating the perimeter of a circle based on its radius.

    @Override
    public void scale(int factor, boolean sign) {
        if (sign) { // if the sign is true, it multiplies the radius by the factor, effectively scaling the circle up. If the sign is false, it divides the radius by the factor, effectively scaling the circle down. This method overrides the abstract scale() method defined in the Shape class, providing a specific implementation for scaling a circle based on its radius and the provided factor and sign.
            radius *= factor;
        } else { // if the sign is false, it divides the radius by the factor, effectively scaling the circle down. This method overrides the abstract scale() method defined in the Shape class, providing a specific implementation for scaling a circle based on its radius and the provided factor and sign.
            if (factor != 0) radius /= factor;
        }
    }

    @Override
    public String display() {
        return "Circle at (" + getPosition().getX() + "," + getPosition().getY() + 
               ") | Radius: " + radius + " | Area: " + String.format("%.2f", getArea());
    }

    private Coordinates getPosition() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPosition'");
    }
}
