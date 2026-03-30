public class Coordinates {
    private int x; // sets a private variable for x and y coordinates
    private int y;

    public Coordinates(int x, int y) { // constructor for the coordinates class that takes in x and y values and sets them to the private variables
        this.x = x; /* the method this. allows for ambiguous references, eliminate the confusion between class attributes and parameters with the same name (because a class attribute is shadowed by a method or constructor parameter)
                        (w3schools, n.d.) */
        this.y = y;
    }
    
    // method to calculate the distance between two coordinates using the distance formula
    public double distance(Coordinates p) { //this method takes in another Coordinates object as a parameter and calculates the distance between the two coordinates using the distance formula: distance = sqrt((x2 - x1)^2 + (y2 - y1)^2)
        double distance = Math.sqrt(Math.pow((p.x - this.x), 2) + Math.pow((p.y - this.y), 2)); //distance formula from the checklist
                        //calculated the distance using the distance formula and the Math.sqrt and Math.pow methods from the Java Math library     
        return distance;
    } 
    public void translate(int dx, int dy) { //this method takes in two integers, dx and dy, which represent the change in x and y coordinates respectively. The method then updates the x and y coordinates by adding the respective changes to them. This effectively translates the point by the specified amounts in the x and y directions.
        
        this.x += dx;// (w3schools, n.d.)
        this.y += dy;

     }
    public void scale(int factor, boolean sign) {  // this method takes an integer factor and a boolean sign as parameters. 
        // If the sign is true, it multiplies the x and y coordinates by the factor, effectively scaling the point up. 
        // If the sign is false, it divides the x and y coordinates by the factor, effectively scaling the point down.
        if (sign) { //if true: 
            this.x *= factor; 
            this.y *= factor;
        } else { // if false:
            this.x /= factor;
            this.y /= factor;
        }
    }

    public String display() { return "X = " + this.x + ", Y = " + this.y; } // this method returns a string representation of the coordinates in the format "X = x, Y = y", where x and y are the current values of the x and y coordinates respectively.

    public String getX() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getX'");
    }

    public String getY() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getY'");
    }

}
