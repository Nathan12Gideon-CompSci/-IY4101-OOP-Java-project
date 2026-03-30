import java.util.Scanner; // to read user input from the command line

/**
 * ShapeManagement is the entry point for the application.
 * It provides a Command Line Interface (CLI) for managing a list of shapes.
 */
public class ShapeManagement {

    public static void main(String[] args) { //we now enter the main method
        // Create the ShapeList object at the start
        ShapeList myShapes = new ShapeList();
        //instialise scanner
        Scanner sc = new Scanner(System.in);

        int choice = -1; // set this choice : HEAVLIY IMPORTANT TO DO SO.

        // Menu runs inside a loop until the user chooses 0
        while (choice != 0) {

            displayMenu(); // calls the displayMenu() method to show the available options to the user. This method is defined later in the code and prints out the menu choices for managing shapes, such as adding a shape, removing a shape, viewing shape details, etc.
            
            // Check if input is an integer to prevent crashes
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); // Consume newline character
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // Clear the invalid input
                continue;
            }
            // switch statement to handle the user's menu choice.
            switch (choice) {
                case 1:
                    addShapeMenu(myShapes, sc); // case 1 calls the addShapeMenu() method, passing in the myShapes ShapeList object and the Scanner object sc. This method is defined later in the code and handles the logic for adding a new shape to the list based on user input, such as selecting the type of shape, entering its dimensions, and creating the corresponding shape object to be added to the ShapeList.
                    break;
                case 2: // case 2 prompts the user to enter the position of the shape they want to remove from the list. It then reads the position as an integer and calls the removeShape() method on the myShapes ShapeList object, passing in the position as an argument. This method is defined in the ShapeList class and handles
                    System.out.print("Enter position to remove: ");
                    int removePos = sc.nextInt();
                    myShapes.removeShape(removePos);
                    break;
                case 3: // case 3 prompts the user to enter the position of the shape they want to view details about. It then reads the position as an integer and calls the getShape() method on the myShapes ShapeList object, passing in the position as an argument. This method returns the shape at the specified position in the list, which is stored in the variable s. If s is not null (i.e., a shape exists at that position), it calls the display() method on that shape to print its details. If s is null, it prints an error message indicating that the shape was not found.
                    System.out.print("Enter position to view: ");
                    int viewPos = sc.nextInt();
                    Shape s = myShapes.getShape(viewPos);
                    if (s != null) {
                        System.out.println(s.display());
                    } else {
                        System.out.println("Error: Shape not found.");
                    }
                    break;
                case 4: // case 4 prompts the user to enter the position of the shape they want to calculate the area and perimeter for. It then reads the position as an integer and calls the area() and perimeter() methods on the myShapes ShapeList object, passing in the position as an argument. These methods return the area and perimeter of the shape at the specified position, which are stored in the variables area and peri respectively. If area is not -1.0 (which indicates that a valid shape was found), it prints out the area and perimeter. If area is -1.0, it does not print anything, which implies that an error message would have been printed by the area() or perimeter() method itself if the shape was not found or if it was an invalid shape for those calculations.
                    System.out.print("Enter position for Area/Perimeter: ");
                    int calcPos = sc.nextInt();
                    double area = myShapes.area(calcPos);
                    double peri = myShapes.perimeter(calcPos);
                    if (area != -1.0) {
                        System.out.println("Area: " + area);
                        System.out.println("Perimeter: " + peri);
                    }
                    break;
                case 5: 
                    // Calls displayAll() on ShapeList
                    myShapes.display();
                    break;
                case 6: // Case 6 prompts User for translation values dx and dy, reads them as integers, and then calls the translate() method on the myShapes ShapeList object, passing in dx and dy as arguments. This method is defined in the ShapeList class and iterates through all shapes in the list, calling their individual translate() methods to update their coordinates based on the provided translation values. After translating all shapes, it prints a confirmation message to the user.
                    System.out.print("Enter translation dx: ");
                    int dx = sc.nextInt();
                    System.out.print("Enter translation dy: ");
                    int dy = sc.nextInt();
                    myShapes.translate(dx, dy);
                    System.out.println("All shapes translated.");
                    break;
                case 7: // Case 7 prompts the user to enter a scaling factor and whether to scale up or down. It reads the scaling factor as an integer and the sign as a boolean. It then calls the scale() method on the myShapes ShapeList object, passing in the factor and sign as arguments. This method is defined in the ShapeList class and iterates through all shapes in the list, calling their individual scale() methods to update their dimensions based on the provided scaling factor and direction (up or down). After scaling all shapes, it prints a confirmation message to the user.
                    System.out.print("Enter scaling factor: ");
                    int factor = sc.nextInt();
                    System.out.print("Scale up (true) or down (false)? ");
                    boolean sign = sc.nextBoolean();
                    myShapes.scale(factor, sign);
                    System.out.println("All shapes scaled.");
                    break;
                case 0:// exit protocol
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default: //if unrecognized input is given, print an error message and prompt the user to try again. This helps guide the user to enter valid menu options and prevents the program from crashing or behaving unexpectedly due to invalid input.
                    System.out.println("Invalid option. Please try again.");
            }
        }
        sc.close();// close the scanner to prevent resource leaks. (www.tutorialspoint.com, n.d.)
    }

    /**
     * Displays the main menu options to the user.
     */
    private static void displayMenu() {// would be better in somewhat more managed fasihon 
        System.out.println("\n********** SHAPE MANAGER **********");
        System.out.println("1 - Add a shape");
        System.out.println("2 - Remove shape by position");
        System.out.println("3 - Get info about one shape");
        System.out.println("4 - Get Area and Perimeter of a shape");
        System.out.println("5 - Display all shapes");
        System.out.println("6 - Translate all shapes");
        System.out.println("7 - Scale all shapes");
        System.out.println("0 - Quit");
        System.out.print("Enter choice: ");
    }

    /**
     * Handles the logic for adding a new shape based on user type selection.
     */
    private static void addShapeMenu(ShapeList list, Scanner sc) { // this method takes in a ShapeList object and a Scanner object as parameters. It prompts the user to select the type of shape they want to add (Circle, Square, Rectangle, or Triangle) and then asks for the necessary dimensions and coordinates based on the selected shape type. It creates a new shape object with the provided information and adds it to the ShapeList using the addShape() method. Finally, it prints a confirmation message indicating that the shape was added successfully.
        System.out.println("Select Type: 1-Circle, 2-Square, 3-Rectangle, 4-Triangle");
        int type = sc.nextInt(); //reads user input as int
        
        System.out.print("Enter X coordinate: "); 
        int x = sc.nextInt();
        System.out.print("Enter Y coordinate: ");
        int y = sc.nextInt();
        Coordinates pos = new Coordinates(x, y);

        if (type == 1) { // if the user selects 1 for Circle, it prompts them to enter the radius of the circle, reads it as an integer, and then creates a new Circle object using the provided position and radius. It then adds this Circle object to the ShapeList using the addShape() method.
            System.out.print("Enter Radius: ");
            int r = sc.nextInt();
            list.addShape(new Circle(pos, r));
        } else if (type == 2) { // if the user selects 2 for Square, it prompts them to enter the side length of the square, reads it as an integer, and then creates a new Square object using the provided position and side length. It then adds this Square object to the ShapeList using the addShape() method.
            System.out.print("Enter Side length: ");
            int s = sc.nextInt();
            list.addShape(new Square(pos, s));
        } else if (type == 3) { // if the user selects 3 for Rectangle, it prompts them to enter the width and length of the rectangle, reads them as integers, and then creates a new Rectangle object using the provided position, width, and length. It then adds this Rectangle object to the ShapeList using the addShape() method.
            System.out.print("Enter Width: ");
            int w = sc.nextInt(); 
            System.out.print("Enter Length: ");
            int l = sc.nextInt();
            list.addShape(new Rectangle(pos, w, l));
        } else if (type == 4) {// if the user selects 4 for Triangle, it prompts them to enter the coordinates of the three vertices of the triangle. It reads these coordinates as integers and creates new Coordinates objects for each vertex. It then creates a new Triangle object using the provided position and the three vertex coordinates, and adds this Triangle object to the ShapeList using the addShape() method.
            // Triangle needs 2 more sets of coordinates
            System.out.print("Enter X2: "); int x2 = sc.nextInt();
            System.out.print("Enter Y2: "); int y2 = sc.nextInt();
            System.out.print("Enter X3: "); int x3 = sc.nextInt();
            System.out.print("Enter Y3: "); int y3 = sc.nextInt();
            list.addShape(new Triangle(pos, new Coordinates(x2, y2), new Coordinates(x3, y3)));
        }
        System.out.println("Shape added successfully."); // After adding the shape to the list, it prints a confirmation message to the user indicating that the shape was added successfully.
    }
}
