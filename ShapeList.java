import java.util.ArrayList; // Sendsin ArrayList and List to the top of the file so that they can be used in the ShapeList class
import java.util.List;

/**
 * ShapeList acts as a container for all Shape objects.
 * It uses an ArrayList to manage the collection dynamically.
 */
public class ShapeList {
    // 1. Private attribute to store the shapes
    private List<Shape> listofShapes; 

    // 2. Constructor: Initializes the empty list
    public ShapeList() {
        this.listofShapes = new ArrayList<>(); // sets the listofShapes variable to a new ArrayList of Shape objects, which will be used to store the shapes in the list.
    }

    // 3. Add a shape to the end of the list
    public void addShape(Shape s) { //creates method to take shape as parameter and add to list. 
        if (s != null) { // checks if the shape is not null before adding it to the list to prevent adding null references, which could lead to errors when trying to access or manipulate the shapes in the list later on.
            listofShapes.add(s);
        }
    }

    // 4. Remove a shape at a specific index with bounds validation
    public void removeShape(int pos) { 
        if (pos >= 0 && pos < listofShapes.size()) { // condition check.
            listofShapes.remove(pos);
        } else {
            System.out.println("Error: No shape exists at position " + pos); // if the provided index is out of bounds (negative or greater than or equal to the size of the list), it prints an error message indicating that no shape exists at the specified position. This helps prevent runtime errors that would occur if you tried to remove an element from an invalid index in the list.
        }
    }

    // 5. Get a specific shape (useful for the menu logic)
    public Shape getShape(int pos) {

        if (pos >= 0 && pos < listofShapes.size()) {
            //if pos is valid, return the shape at that position in the list. This allows other parts of the program to access specific shapes in the list based on their index, which can be useful for various operations such as displaying details, translating, or scaling a particular shape.
            return listofShapes.get(pos);
        }
        return null; // returns null if the provided index is out of bounds, indicating that there is no shape at the specified position. This allows the calling code to handle the case where an invalid index was provided, such as by displaying an error message or prompting the user to enter a valid index.
    }

    // 6. Get the total number of shapes in the list
    public int getCount() {
        // returns the size of the listofShapes, which represents the total number of shapes currently stored in the list. This method allows other parts of the program to easily retrieve the count of shapes without needing to directly access the list or its size property.
        return listofShapes.size();
    }

    // 7. Translate ALL shapes in the list at once
    public void translate(int dx, int dy) {

        for (Shape s : listofShapes) { // iterates through each shape in the listofShapes and calls the translate method on each shape,
        //  passing in the dx and dy values. This allows all shapes in the list to be translated (moved) by the specified amounts in the 
        // x and y directions simultaneously, providing a convenient way to apply the same translation to multiple shapes at once.
            s.translate(dx, dy); //we put s.translate(dx, dy) inside the loop to ensure that the translate method is called for each shape in the list, allowing all shapes to be translated according to the provided dx and dy values.
        }
    }

    // 8. Scale ALL shapes in the list at once
    public void scale(int factor, boolean sign) {

        for (Shape s : listofShapes) {
            s.scale(factor, sign); // iterates through each shape in the listofShapes and calls the scale method on each shape, passing in the factor and sign values. This allows all shapes in the list to be scaled (resized) by the specified factor, either up or down depending on the value of sign, simultaneously. This provides a convenient way to apply the same scaling transformation to multiple shapes at once.
        }
    }

    // 9. Display details for every shape in the list
    public void display() {
        if (listofShapes.isEmpty()) {

            System.out.println("The list is currently empty."); //pretty self-explanatory

        } else {

            for (int i = 0; i < listofShapes.size(); i++) { // iterates through each shape in the listofShapes using a for loop, where i is the index of the current shape. This allows the program to access each shape in the list and display its details one by one.

                // Displays the index (i) followed by the shape's specific details
                System.out.println("[" + i + "] " + listofShapes.get(i).display()); // for each shape, it prints the index (i) in square brackets followed by the result of calling the display method on the shape at that index in the list. This assumes that each shape class (like Circle, Square, etc.) has its own implementation of the display method that returns a string representation of the shape's details, such as its type, dimensions, area, perimeter, etc. This allows users to see a list of all shapes along with their specific information in a clear and organized manner.
            }
        }
    }
}
    

