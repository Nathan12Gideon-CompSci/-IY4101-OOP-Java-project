public class Coordinates {// Coordinates class to represent a point in 2D space with x and y coordinates, and to provide methods for calculating distance, translating, scaling, and displaying the coordinates.
    private int x;// Private field to store the x coordinate of the point
    private int y;// Private field to store the y coordinate of the point

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }// Constructor to initialize the x and y coordinates of the point when a new Coordinates object is created, allowing the user to specify the location of the point in a 2D space.
    
    public double distance(Coordinates p) {
        return Math.sqrt(Math.pow((p.x - this.x), 2) + Math.pow((p.y - this.y), 2));
    }// Method to calculate the distance between this point and another point p using the distance formula derived from the Pythagorean theorem, which computes the square root of the sum of the squares of the differences in x and y coordinates.

    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }// Method to translate the point by adding the specified dx and dy values to the x and y coordinates, respectively, allowing the user to move the point by a certain amount in both directions.

    public void scale(int factor, boolean sign) {
        if (sign) {// If the sign is true, it scales up the coordinates by multiplying them by the factor, effectively increasing the distance of the point from the origin (0,0) by the specified factor.
            this.x *= factor; 
            this.y *= factor;
        } else {// If the sign is false, it scales down the coordinates by dividing them by the factor, effectively decreasing the distance of the point from the origin by the specified factor. It also includes a check to prevent division by zero, ensuring that the scaling operation is valid and does not cause an error.
            // Added check to prevent division by zero
            if (factor != 0) {
                this.x /= factor;
                this.y /= factor;
            }// If the factor is zero, it does not perform any scaling to avoid division by zero, which would cause an error. This ensures that the method behaves safely even if the user provides an invalid scaling factor.
        }
    }

    public String display() { 
        return "(" + this.x + ", " + this.y + ")"; 
    }// Method to return a string representation of the coordinates in the format "(x, y)", allowing the user to easily see the current position of the point when it is displayed.

    // Fixed: Now returns int to match the field types
    public int getX() {
        return this.x;
    }// Method to return the x coordinate of the point, allowing other classes (such as shapes) to access the x value when needed for calculations or display purposes.

    public int getY() {
        return this.y;
    }// Method to return the y coordinate of the point, allowing other classes to access the y value when needed for calculations or display purposes.
}
