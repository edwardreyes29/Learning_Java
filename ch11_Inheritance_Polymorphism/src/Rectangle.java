public class Rectangle extends GeometricObject {
    private double width;
    private double height;

    public Rectangle() {}

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color,
                     boolean filled) {
        this.width = width;
        this.height = height;
        setColor(color); // this.color = color won't work, can only be accessed in GeometricObject class.
        setFilled(filled); // Only way to read & modify color & filled is through their getter and setter methods.
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    /** Return area */
    public double getArea() {
        return width * height;
    }

    /** Return perimeter */
    public double getPerimeter() {
        return 2 * (width + height);
    }
}
