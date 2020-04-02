// Subclass: Circle, Superclass: GeometricObject
// Circle inherits methods from GeometricObject, which allows it
// to access the fields from the method, not directly.
public class Circle extends GeometricObject {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
//        setColor(color);
//        setFilled(filled);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /** Return area */
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /** Return diameter */
    public double getDiameter() {
        return 2 * radius;
    }

    /** Return perimeter */
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    /** Print the circle info */
    public void printCircle() {
        System.out.println("The circle is created " + getDateCreated() +
                " and the radius is " + radius);
    }

    // Override the toString method defined in the superclass
    // @Override denotes that method is required to override a method in superclass.
    // Otherwise it will report an error if the method does not override it's superclass's method.
    @Override
    public String toString() {
        return super.toString() + "\nradius is " + radius;
    }
}
