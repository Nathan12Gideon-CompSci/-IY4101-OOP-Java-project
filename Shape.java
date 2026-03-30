public abstract class Shape { // we set the class to be abstract because we will not be creating any objects of the Shape class, but rather 
 //using it as a base class for other shapes (like Circle, Square, etc.) that will inherit from it and implement the abstract methods defined in the Shape class.
    protected Coordinates position; // sets a private variable for the position of the shape using the Coordinates class
    @SuppressWarnings("unused")
    private int sides; // sets a private variable for the number of sides of the shape

    public Shape(int sides, Coordinates position) {
        //the constructor for the Shape class takes in an integer sides and a Coordinates object position as parameters. It initializes the sides variable with the provided value and sets the position variable to the given Coordinates object, which represents the location of the shape in a 2D space.
        this.sides = sides;
        this.position = position;
     // initializes the position variable with the provided Coordinates object
     }

    public void translate(int dx, int dy) { // using The translate method from the Coordinates class to move the shape by a certain amount in the x and y directions. It takes in two integers, dx and dy, which represent the change in x and y coordinates respectively. The method then calls the translate method of the position variable (which is a Coordinates object) to update the coordinates of the shape accordingly.
        position.translate(dx, dy); // Reuses Coordinate's logic! 
    }

    // Abstract methods to be overridden by children programs: set this method and all others to abstract since they will be different for each shape.
    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract void scale(int factor, boolean sign);

    public abstract String display();
    
}
