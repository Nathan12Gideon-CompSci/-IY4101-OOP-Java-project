public class Square extends Shape { // Square class extends the abstract Shape class
    private int side; // Private field to store the length of the square's side

    public Square(Coordinates position, int side) {// Constructor to initialize the square's position and side length
        super(4, position); // Calls the superclass (Shape) constructor to set sides to 4 and the position
        this.side = side;
    }

    @Override
    public double getArea() { return side * side; } // Area of a square : A = side^2

    @Override
    public double getPerimeter() { return 4 * side; }// Perimeter of a square : P = 4 * side

    @Override
    public void scale(int factor, boolean sign) { // Scales the side length of the square based on the factor and sign
        if (sign) side *= factor; // If sign is true, the side length is multiplied by the factor to scale up
        else if (factor != 0) side /= factor; // If sign is false and factor is not zero, the side length is divided by the factor to scale down, with a check to prevent division by zero
    }

    @Override
    public String display() {// Returns a string representation of the square, including its position, side length, and area formatted to two decimal places for readability
        return "Square at (" + position.getX() + "," + position.getY() + 
               ") | Side: " + side + " | Area: " + String.format("%.2f", getArea());
    }
}
