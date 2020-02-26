public class Test {
    public static void main(String[] args) {
        // CircleWithPrivateDataFields instance
        CircleWithPrivateDataFields myCircle = new CircleWithPrivateDataFields();
        printCircle(myCircle);

        // Student class
        Student student = new Student(111223333, "John");
        System.out.println(student.getDateCreated());
        java.util.Date dateCreated = student.getDateCreated();
        dateCreated.setTime(200000); // Now dateCreated field is changed!
        System.out.println(student.getDateCreated());
    }

    public static void printCircle(CircleWithPrivateDataFields c) {
        System.out.println("The area of the circle of radius " +
                c.getRadius() + " is " + c .getArea());
    }
}


