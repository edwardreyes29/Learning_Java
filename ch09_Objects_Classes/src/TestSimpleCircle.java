public class TestSimpleCircle {
    /** Main method */
    public static void main(String[] args) {
        // Create a circle with radius 1
        SimpleCircle circle1 = new SimpleCircle();
        System.out.println("The area of the circle of raidus " + circle1.radius + " is " + circle1.getArea());

        SimpleCircle circle2 = new SimpleCircle();
        SimpleCircle circle3 = new SimpleCircle();
        System.out.println("The number of circle objects is: " + SimpleCircle.getNumberObjects());

    } // end main method
} // end TestSimpleCircle class

// Define he circle class with two constructors.
class SimpleCircle {
    static int numberOfObjects;
    double radius; // default visibility has package-access

    /** Construct a circle with radius 1 */
    SimpleCircle() {
        radius = 1;
        numberOfObjects++;
    }

    /** Construct a circle with specified radius */
    SimpleCircle(double radius) {
        this.radius = radius;
    }

    /** Return the area of this circle */
    double getArea() {
        return radius * radius * Math.PI;
    }

    /** Return the perimeter of this circle */
    double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    /** Set a new radius for this circle */
    void setRadius(double newRadius) {
        radius = newRadius;
    }

    static int getNumberObjects() {
        return numberOfObjects;
    }
} // end SimpleCircle class
