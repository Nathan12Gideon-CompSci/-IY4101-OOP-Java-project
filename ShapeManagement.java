import java.util.Scanner; // Added for reading user input from the console
// the main point of this class is to provide a user interface for managing shapes, allowing users to add, remove, view, and manipulate shapes in a list through a console-based menu system. It interacts with the ShapeList class to perform operations on the collection of shapes and uses the Scanner class to read user input from the console.

public class ShapeManagement {
    public static void main(String[] args) { // The main method serves as the entry point of the program, where it initializes a ShapeList to store shapes and uses a Scanner to read user input for managing the shapes through a menu-driven interface.
        ShapeList myShapes = new ShapeList(); // Initializes a new ShapeList object to store and manage the collection of shapes that the user will interact with throughout the program.
        Scanner sc = new Scanner(System.in); // Creates a Scanner object to read user input from the console, allowing the program to capture user choices and shape parameters for various operations.
        int choice = -1; // Initializes a variable to store the user's menu choice, starting with -1 to ensure the menu is displayed at least once and to control the flow of the program based on user input.

        while (choice != 0) { // Enters a loop that continues until the user chooses to exit (by entering 0). Inside the loop, it displays the menu, reads the user's choice, and performs actions based on that choice using a switch statement.
            displayMenu();

            if (sc.hasNextInt()) { // Checks if the next input is an integer before attempting to read it, which helps prevent InputMismatchException and ensures that the program can handle invalid input gracefully.
                choice = sc.nextInt(); // Reads the user's menu choice as an integer, which will determine the action to be performed in the switch statement that follows.
                sc.nextLine(); // Consumes the newline character left in the input buffer after reading the integer, ensuring that subsequent calls to sc.nextLine() will work correctly for reading string input without being skipped.
            } else { // If the input is not an integer, it prints an error message and continues the loop to prompt the user again, allowing for robust handling of invalid input without crashing the program.
                System.out.println("Invalid input.");
                sc.nextLine();
                continue;// Continues to the next iteration of the loop, prompting the user again for a valid menu choice.
            }

            switch (choice) {  // Uses a switch statement to execute different blocks of code based on the user's menu choice, allowing for organized and clear handling of various operations such as adding shapes, removing shapes, displaying information, and manipulating shapes in the list.
                case 1: addShapeMenu(myShapes, sc); break; // Calls a helper method to handle the process of adding a new shape to the ShapeList, passing the current ShapeList and Scanner as arguments to facilitate user input for shape parameters.
                case 2:// Prompts the user to enter the position of the shape they wish to remove from the ShapeList, reads the input, and then calls the removeShape method of ShapeList to remove the shape at the specified position.
                    System.out.print("Enter position: ");
                    myShapes.removeShape(sc.nextInt()); // Reads the position as an integer and attempts to remove the shape at that index from the list, with error handling in the ShapeList class to manage invalid positions.
                    sc.nextLine();
                    break;
                case 3:// Prompts the user to enter the position of the shape they wish to view information about, reads the input, retrieves the shape from the ShapeList using getShape, and then displays its information using the display method of the Shape class. If the shape is not found (i.e., getShape returns null), it prints "Not found."
                    System.out.print("Enter position: ");
                    Shape s = myShapes.getShape(sc.nextInt());// Reads the position as an integer and retrieves the shape at that index from the list, storing it in a variable for later use in displaying its information.
                    sc.nextLine();
                    System.out.println(s != null ? s.display() : "Not found.");
                    break;
                case 4:
                    System.out.print("Enter position: ");// Prompts the user to enter the position of the shape for which they want to calculate the area and perimeter, reads the input, and then calls the area and perimeter methods of ShapeList to retrieve and display the area and perimeter of the shape at the specified position. If the shape is not found (i.e., area returns -1.0), it does not display any information.
                    int p = sc.nextInt(); sc.nextLine();
                    double a = myShapes.area(p);// Reads the position as an integer and retrieves the area of the shape at that index from the list, storing it in a variable for later use in displaying the area and perimeter information.
                    if (a != -1.0) System.out.println("Area: " + a + "\nPerimeter: " + myShapes.perimeter(p));
                    break;
                case 5: myShapes.display(); break;// Calls the display method of ShapeList to print out the details of all shapes currently in the list, allowing the user to see a summary of all shapes they have added and their respective information.
                case 6:
                    System.out.print("dx: "); int dx = sc.nextInt();// Prompts the user to enter the translation values for the x and y directions, reads the input, and then calls the translate method of ShapeList to translate all shapes in the list by the specified amounts in the x and y directions.
                    System.out.print("dy: "); int dy = sc.nextInt();// Reads the translation values as integers and stores them in variables for later use in translating the shapes in the list.
                    sc.nextLine();
                    myShapes.translate(dx, dy);// Calls the translate method of ShapeList, passing the dx and dy values to translate all shapes in the list accordingly, allowing the user to move all shapes by a specified amount in both directions.
                    break;
                case 7:
                    System.out.print("Factor: "); int f = sc.nextInt();// Prompts the user to enter a scaling factor and whether to scale up or down, reads the input, and then calls the scale method of ShapeList to scale all shapes in the list based on the provided factor and direction (up or down).
                    System.out.print("Scale up (true/false): "); boolean up = sc.nextBoolean();
                    // Reads the scaling factor as an integer and the direction as a boolean, storing them in variables for later use in scaling the shapes in the list.
                    sc.nextLine();
                    myShapes.scale(f, up);// Calls the scale method of ShapeList, passing the factor and direction to scale all shapes in the list accordingly, allowing the user to resize all shapes by a specified factor either up or down based on their choice.
                    break;
                case 0: System.out.println("Goodbye!"); break;// If the user chooses to exit (by entering 0), it prints a goodbye message and breaks out of the switch statement, which will then exit the while loop and end the program.
                default: System.out.println("Invalid choice."); break;// If the user enters a menu choice that does not match any of the defined cases, it falls into the default case, which prints an "Invalid choice." message to inform the user that their input was not recognized and prompts them to try again.
            }
        }
        sc.close();// Closes the Scanner object to free up system resources, as it is no longer needed after the user has chosen to exit the program. This is a good practice to prevent resource leaks and ensure that the program cleans up properly after execution.
    }

    private static void displayMenu() {// A helper method to display the menu options to the user, providing a clear and organized list of available actions that the user can perform on the shapes in the ShapeList. This method is called at the beginning of each iteration of the main loop to ensure that the user always has access to the menu options before making a choice.
        System.out.println("\n--- SHAPE MANAGER ---");
        System.out.println("1-Add, 2-Remove, 3-Info, 4-Calc, 5-Display All, 6-Translate, 7-Scale, 0-Quit");
        System.out.print("Choice: ");
    }

    private static void addShapeMenu(ShapeList list, Scanner sc) {
        System.out.print("Type (1-Circle, 2-Square, 3-Rect, 4-Tri): "); // Prompts the user to enter the type of shape they want to add (Circle, Square, Rectangle, or Triangle) by entering a corresponding number, reads the input, and then based on the user's choice, it prompts for additional parameters specific to that shape type (such as radius for Circle, side length for Square, width and length for Rectangle, or vertex coordinates for Triangle) before creating the shape and adding it to the ShapeList.
        int type = sc.nextInt();
        System.out.print("X: "); int x = sc.nextInt();// Prompts the user to enter the x and y coordinates for the position of the shape, reads the input, and then creates a Coordinates object with those values to be used as the position for the new shape being added to the ShapeList.
        System.out.print("Y: "); int y = sc.nextInt();// Reads the y coordinate as an integer and stores it in a variable for later use in creating the Coordinates object that will represent the position of the new shape being added to the ShapeList.
        Coordinates pos = new Coordinates(x, y);// Creates a new Coordinates object using the x and y values provided by the user, which will be used as the position for the new shape that is being added to the ShapeList. This allows the user to specify where the shape should be located in a 2D space when it is created.

        if (type == 1) {
            System.out.print("Radius: ");// If the user chooses to add a Circle (by entering 1), it prompts them to enter the radius of the circle, reads the input, and then creates a new Circle object with the specified position and radius before adding it to the ShapeList.
            list.addShape(new Circle(pos, sc.nextInt())); // Reads the radius as an integer and creates a new Circle object using the position and radius, then adds it to the ShapeList using the addShape method.
        } else if (type == 2) {// If the user chooses to add a Square (by entering 2), it prompts them to enter the side length of the square, reads the input, and then creates a new Square object with the specified position and side length before adding it to the ShapeList.
            System.out.print("Side: ");// Prompts the user to enter the side length of the square, reads the input, and then creates a new Square object using the position and side length, before adding it to the ShapeList using the addShape method.
            list.addShape(new Square(pos, sc.nextInt()));// Reads the side length as an integer and creates a new Square object using the position and side length, then adds it to the ShapeList using the addShape method.
        } else if (type == 3) {// If the user chooses to add a Rectangle (by entering 3), it prompts them to enter the width and length of the rectangle, reads the input, and then creates a new Rectangle object with the specified position, width, and length before adding it to the ShapeList.
            System.out.print("Width: "); int w = sc.nextInt();
            System.out.print("Length: "); int l = sc.nextInt();
            list.addShape(new Rectangle(pos, w, l));// Reads the width and length as integers, creates a new Rectangle object using the position, width, and length, then adds it to the ShapeList using the addShape method.
        } else if (type == 4) {// If the user chooses to add a Triangle (by entering 4), it prompts them to enter the coordinates of the three vertices of the triangle, reads the input, and then creates a new Triangle object with the specified position and vertex coordinates before adding it to the ShapeList.
            System.out.print("X2 Y2 X3 Y3: ");
            list.addShape(new Triangle(pos, new Coordinates(sc.nextInt(), sc.nextInt()), new Coordinates(sc.nextInt(), sc.nextInt())));
        }// Reads the coordinates of the second and third vertices as integers, creates new Coordinates objects for those vertices, creates a new Triangle object using the position and vertex coordinates, then adds it to the ShapeList using the addShape method.
        sc.nextLine();
        System.out.println("Added.");// After successfully adding the new shape to the ShapeList, it prints a confirmation message "Added." to inform the user that their shape has been created and stored in the list.
    }
}
