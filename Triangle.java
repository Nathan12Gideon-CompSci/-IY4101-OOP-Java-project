public class Triangle extends Shape { // Triangle class extends the abstract Shape class
    private Coordinates v1, v2, v3; // Private fields to store the coordinates of the three vertices of the triangle

    public Triangle(Coordinates v1, Coordinates v2, Coordinates v3) {
        super(3, v1); // Calls the superclass (Shape) constructor to set sides to 3 and the position to the first vertex (v1)
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public double getPerimeter() { // Perimeter of a triangle is the sum of the lengths of its sides
        return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
    }

    @Override
    public double getArea() { // Area of a triangle can be calculated using Heron's formula, which requires the lengths of the sides and the semi-perimeter
        double a = v1.distance(v2), b = v2.distance(v3), c = v3.distance(v1);
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public void translate(int dx, int dy) {
        v1.translate(dx, dy); 
        v2.translate(dx, dy);
        v3.translate(dx, dy);
    }// Translates each vertex of the triangle by the specified amounts in the x and y directions

    @Override
    public void scale(int factor, boolean sign) { 
        v1.scale(factor, sign);
        v2.scale(factor, sign);
        v3.scale(factor, sign);
    } // Scales the triangle by scaling each vertex based on the factor and sign

    @Override
    public String display() {
        return "Triangle | V1(" + v1.getX() + "," + v1.getY() + ") V2(" + v2.getX() + "," + v2.getY() + ") V3(" + v3.getX() + "," + v3.getY() + ") | Area: " + String.format("%.2f", getArea());
    } // Returns a string representation of the triangle, including the coordinates of its vertices and its area formatted to two decimal places for readability
} 
