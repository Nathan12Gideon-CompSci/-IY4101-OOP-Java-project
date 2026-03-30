
public class Square extends Shape { // the Square class extends the Shape class, meaning it inherits the properties and methods of the Shape class and can also have its own specific properties and methods related to a square shape.
    private int side; // sets a private variable for the side length of the square, which is specific to the Square class and is used to calculate the area and perimeter of the square.

    public Square(Coordinates position, int side) {
        super(4, position); // Tells parent: 4 sides, at this position
        this.side = side;
    }

    @Override //(zfm, 2011)
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (sign) { // if the sign is true, it multiplies the side length by the factor, effectively scaling the square up. If the sign is false, it divides the side length by the factor, effectively scaling the square down. This method overrides the abstract scale() method defined in the Shape class, providing a specific implementation for scaling a square based on its side length and the provided factor and sign.
            side *= factor;
        } else { // if the sign is false, it divides the side length by the factor, effectively scaling the square down. This method overrides the abstract scale() method defined in the Shape class, providing a specific implementation for scaling a square based on its side length and the provided factor and sign.
            if (factor != 0) side /= factor;
        }
    }

    @Override
    public String display() {
        // Uses position from the parent to get X and Y
        return "Square at (" + this.position.getX() + "," + this.position.getY() + 
               ") | Side: " + side + " | Area: " + String.format("%.2f", getArea());
    }
}