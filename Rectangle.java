public class Rectangle extends Shape { // Rectangle class extends the abstract Shape class
    private int width; // Private field to store the width of the rectangle
    private int length;// Private field to store the length of the rectangle

    public Rectangle(Coordinates position, int width, int length) {
        // Calls the superclass (Shape) constructor to set sides to 4 and the position
        super(4, position); // Initializes the width and length fields with the provided values
        this.width = width;
        this.length = length;
    }

    @Override 
    public double getArea() {  // Area of a rectangle : A = width * length
        // Calculates area by multiplying width and length
        return (double) width * length; 
    } 

    @Override 
    public double getPerimeter() { // Perimeter of a rectangle : P = 2 * (width + length)
        // Calculates perimeter as the sum of all sides
        return 2.0 * (width + length); 
    } 

    @Override
    public void scale(int factor, boolean sign) { // Scales the width and length of the rectangle based on the factor and sign
        if (sign) {
            // Scales width and length up
            width *= factor; 
            length *= factor;
        } else if (factor != 0) { 
            // Scales width and length down, with a check to prevent division by zero
            width /= factor;
            length /= factor;
        }
    }

    @Override
    public String display() { 
        // Updated to include the position for consistency and formatted numbers for readability
        return "Rectangle at (" + position.getX() + "," + position.getY() + 
               ") | Width: " + width + ", Length: " + length + 
               " | Area: " + String.format("%.2f", getArea()) + 
               " | Perimeter: " + String.format("%.2f", getPerimeter());
    } //the use of String.format("%.2f", value) ensures that the area and perimeter are displayed with two decimal places for better readability
}   //(V, 2024)
