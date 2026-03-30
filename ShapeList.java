import java.util.ArrayList;// Added for ArrayList
import java.util.List;// Added for List interface

public class ShapeList {// The ShapeList class manages a collection of Shape objects, allowing for operations such as adding, removing, translating, scaling, and displaying shapes in the list. It uses an ArrayList to store the shapes and provides methods to manipulate and retrieve information about the shapes in the collection.
    private List<Shape> listofShapes = new ArrayList<>();//created a private List of Shape objects called listofShapes, which is initialized as an ArrayList. This list will be used to store and manage the shapes that are added to the ShapeList.

    public void addShape(Shape s) {
        if (s != null) listofShapes.add(s);
    }// The addShape method takes a Shape object as a parameter and adds it to the listofShapes if it is not null, allowing the user to build a collection of shapes in the ShapeList.

    public void removeShape(int pos) {
        if (pos >= 0 && pos < listofShapes.size()) listofShapes.remove(pos);
        else System.out.println("Error: Invalid position.");
    }// The removeShape method takes an integer position as a parameter and removes the shape at that position from the listofShapes if the position is valid (i.e., within the bounds of the list). If the position is invalid, it prints an error message to inform the user.

    public Shape getShape(int pos) {
        if (pos >= 0 && pos < listofShapes.size()) return listofShapes.get(pos);
        return null;
    }// The getShape method takes an integer position as a parameter and returns the shape at that position from the listofShapes if the position is valid. If the position is invalid, it returns null, allowing the user to retrieve specific shapes from the collection based on their index.

    public void translate(int dx, int dy) {
        for (Shape s : listofShapes) s.translate(dx, dy);
    }// The translate method takes two integers, dx and dy, as parameters and translates all shapes in the listofShapes by those amounts in the x and y directions, respectively. It iterates through each shape in the list and calls their translate method to move them accordingly.

    public void scale(int factor, boolean sign) {
        for (Shape s : listofShapes) s.scale(factor, sign);
    }// The scale method takes an integer factor and a boolean sign as parameters and scales all shapes in the listofShapes based on those parameters. It iterates through each shape in the list and calls their scale method, passing the factor and sign to determine how each shape should be resized (either scaled up or down).

    public double area(int pos) {
        Shape s = getShape(pos);
        return (s != null) ? s.getArea() : -1.0;
    }// The area method takes an integer position as a parameter and returns the area of the shape at that position in the listofShapes. It first retrieves the shape using the getShape method, and if the shape is not null, it calls its getArea method to calculate and return the area. If the shape is null (i.e., the position is invalid), it returns -1.0 to indicate an error.

    public double perimeter(int pos) {
        Shape s = getShape(pos);
        return (s != null) ? s.getPerimeter() : -1.0;
    }// The perimeter method takes an integer position as a parameter and returns the perimeter of the shape at that position in the listofShapes. Similar to the area method, it retrieves the shape using getShape, checks if it is not null, and then calls its getPerimeter method to calculate and return the perimeter. If the shape is null, it returns -1.0 to indicate an error.

    public void display() {// The display method prints out the details of all shapes in the listofShapes. If the list is empty, it informs the user that the list is currently empty. Otherwise, it iterates through each shape in the list and prints its index and a string representation of the shape using its display method, allowing the user to see information about all shapes currently stored in the ShapeList.
        if (listofShapes.isEmpty()) {// Checks if the listofShapes is empty, and if so, it prints a message to inform the user that there are no shapes in the list to display.
            System.out.println("The list is currently empty.");
        } else {
            for (int i = 0; i < listofShapes.size(); i++) {
                System.out.println("[" + i + "] " + listofShapes.get(i).display());
            }// If the listofShapes is not empty, it iterates through each shape in the list using a for loop, printing the index of each shape (enclosed in square brackets) followed by the string representation of the shape obtained by calling its display method. This allows the user to see a numbered list of all shapes currently stored in the ShapeList along with their details.
        }
    }
}
