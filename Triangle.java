
public class Triangle extends Shape { // the Triangle class extends the Shape class, meaning it inherits the properties and methods of the Shape class and can also have its own specific properties and methods related to a triangle shape.
    private Coordinates v1; 
    private Coordinates v2;
    private Coordinates v3;

    public Triangle(Coordinates v1, Coordinates v2, Coordinates v3) {
        super(3, v1); // v1 is treated as the main 'position'
        this.v1 = v1; // sets the private variables v1, v2, and v3 to represent the three vertices of the triangle. These variables are specific to the Triangle class and are used to calculate the area and perimeter of the triangle, as well as to perform translations and scaling operations on the triangle.
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public double getPerimeter() { // the getPerimeter() method calculates and returns the perimeter of the triangle by summing the distances between each pair of vertices (v1 to v2, v2 to v3, and v3 to v1). It uses the distance() method from the Coordinates class to calculate the distance between each pair of vertices. This method overrides the abstract getPerimeter() method defined in the Shape class, providing a specific implementation for calculating the perimeter of a triangle based on its vertex coordinates.
        return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
    }

    @Override
    public double getArea() {// the getArea() method calculates and returns the area of the triangle using Heron's formula. It first calculates the lengths of the sides of the triangle (a, b, and c) by finding the distances between each pair of vertices using the distance() method from the Coordinates class. 
    // Then, it calculates the semi-perimeter (s) by dividing the perimeter of the triangle by 2. Finally, it applies Heron's formula to calculate and return the area of the triangle based on the lengths of its sides and its semi-perimeter. 
    // This method overrides the abstract getArea() method defined in the Shape class, providing a specific implementation for calculating the area of a triangle based on its vertex coordinates.
        double a = v1.distance(v2);
        double b = v2.distance(v3);
        double c = v3.distance(v1);
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));// Heron's formula for area of a triangle based on its sides (cite: 91)
    }

    @Override
    public void translate(int dx, int dy) { 
        // We move all 3 points so the triangle stays the same shape
        v1.translate(dx, dy);
        v2.translate(dx, dy);
        v3.translate(dx, dy);
    }

    @Override
    public void scale(int factor, boolean sign) { //    the scale() method takes an integer factor and a boolean sign as parameters. It scales the triangle by applying the scaling operation to each of its vertices (v1, v2, and v3) using the scale() method from the Coordinates class. If the sign is true, it multiplies the coordinates of each vertex by the factor, effectively scaling the triangle up. If the sign is false, it divides the coordinates of each vertex by the factor, effectively scaling the triangle down. This method overrides the abstract scale() method defined in the Shape class, providing a specific implementation for scaling a triangle based on its vertex coordinates and the provided factor and sign.
        // Scales all points using the logic in Coordinates.java
        v1.scale(factor, sign);
        v2.scale(factor, sign);
        v3.scale(factor, sign);
    }

    @Override
    public String display() {
        return "Triangle | V1(" + v1.getX() + "," + v1.getY() + 
               ") V2(" + v2.getX() + "," + v2.getY() + 
               ") V3(" + v3.getX() + "," + v3.getY() + ") | Area: " + String.format("%.2f", getArea());
    }// the display() method returns a string representation of the triangle, including its type (Triangle), the coordinates of its three vertices (v1, v2, and v3), and its area. It uses the getArea() method to calculate the area value to include in the display string. This method overrides the abstract display() method defined in the Shape class, providing a specific implementation for displaying the details of a triangle based on its vertex coordinates and calculated area.
}
