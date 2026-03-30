public abstract class Shape { // Abstract class to represent a generic shape, which will be extended by specific shape classes like Circle, Square, Rectangle, and Triangle. This class defines common properties and methods that all shapes will have, such as position, number of sides, area, perimeter, translation, scaling, and display functionality.
    protected Coordinates position; // Protected field to store the position of the shape, which is accessible to subclasses but not to other classes outside the hierarchy.
    protected int sides; // Protected field to store the number of sides of the shape, which is set by the subclasses when they call the superclass constructor.

    public Shape(int sides, Coordinates position) {//   Constructor to initialize the shape's number of sides and position, which will be called by the subclasses when they create specific shapes. This constructor sets the sides and position fields based on the parameters provided by the subclasses.
        this.sides = sides;//(w3schools, n.d.)
        this.position = position;// Initializes the sides and position fields with the values provided as parameters when a new shape is created. The sides parameter indicates how many sides the shape has (e.g., 0 for Circle, 4 for Square and Rectangle, 3 for Triangle), while the position parameter specifies where the shape is located in a 2D space using a Coordinates object.
    }

    public void translate(int dx, int dy) {
        position.translate(dx, dy); // Translates the shape by updating its position based on the provided dx and dy values, which represent the amount to move the shape in the x and y directions, respectively. This method calls the translate method of the Coordinates class to update the position of the shape accordingly.
    }

    public abstract double getArea();// Abstract method to calculate the area of the shape, which must be implemented by each specific shape subclass (Circle, Square, Rectangle, Triangle) to provide the appropriate area calculation based on their unique properties and formulas. 
    public abstract double getPerimeter();// Abstract method to calculate the perimeter of the shape, which must be implemented by each specific shape subclass to provide the appropriate perimeter calculation based on their unique properties and formulas.
    public abstract void scale(int factor, boolean sign);// Abstract method to scale the shape, which must be implemented by each specific shape subclass to provide the appropriate scaling behavior based on their unique properties. The factor parameter indicates how much to scale the shape, while the sign parameter indicates whether to scale up (true) or down (false).
    public abstract String display();// Abstract method to return a string representation of the shape, which must be implemented by each specific shape subclass to provide a meaningful description of the shape, including its type, position, dimensions, area, and perimeter as appropriate for that shape.
}
