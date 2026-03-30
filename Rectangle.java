public class Rectangle extends Shape {
    private int width; // sets private variables for the width and length of the rectangle
    private int length;

    public Rectangle(Coordinates position, int width, int length) {
        // the constructor for the Rectangle class takes in a Coordinates object position, an integer width, and an integer length as parameters. It calls the constructor of the superclass (Shape) using super() to initialize the sides variable with 4 (since a rectangle has 4 sides) and sets the position variable to the provided Coordinates object. It then initializes the width and length variables with the provided values.
        super(4, position); // sets the sides variable to 4 (since a rectangle has 4 sides) and initializes the position variable with the provided Coordinates object by calling the constructor of the superclass (Shape) using super().
        this.width = width;
        this.length = length;
    }

    @Override //(zfm, 2011)
    public double getArea() { return width * length; } // the getArea() method calculates and returns the area of the rectangle by multiplying the width and length variables together. This method overrides the abstract getArea() method defined in the Shape class, providing a specific implementation for calculating the area of a rectangle based on its dimensions.

    @Override // overrides the getPerimeter() method from the Shape class to provide a specific implementation for calculating the perimeter of a rectangle based on its dimensions. The getPerimeter() method calculates and returns the perimeter of the rectangle by adding twice the width and twice the length together.
    public double getPerimeter() { return 2 * width + 2 * length; } //  the getPerimeter() method calculates and returns the perimeter of the rectangle by adding twice the width and twice the length together. This method overrides the abstract getPerimeter() method defined in the Shape class, providing a specific implementation for calculating the perimeter of a rectangle based on its dimensions.

    @Override
    public void scale(int factor, boolean sign) { // the scale() method takes an integer factor and a boolean sign as parameters. If the sign is true, it multiplies the width and length by the factor, effectively scaling the rectangle up. If the sign is false, it divides the width and length by the factor, effectively scaling the rectangle down. This method overrides the abstract scale() method defined in the Shape class, providing a specific implementation for scaling a rectangle based on its dimensions and the provided factor and sign.
        if (sign) {
            width *= factor; 
            length *= factor;
        } else {
            width /= factor;
            length /= factor;
        }
    }

    @Override
    public String display() { // the display() method returns a string representation of the rectangle, including its type (Rectangle), width, length, area, and perimeter. It uses the getArea() and getPerimeter() methods to calculate the area and perimeter values to include in the display string. This method overrides the abstract display() method defined in the Shape class, providing a specific implementation for displaying the details of a rectangle.
        return "Rectangle | Width: " + width + ", Length: " + length + ", Area: " + getArea() + ", Perimeter: " + getPerimeter(); // [cite: 91]
    }
}
