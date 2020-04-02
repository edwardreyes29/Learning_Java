/*
    Shows an example of constructor chaining
 */

public class Faculty extends Employee {
    public Faculty() {
        System.out.println("(4) Performs Faculty's tasks");
    }

    public static void main(String[] args) {
//        new Faculty();
    }
}

class Employee extends Person {
    public Employee() {
        this("(2) Invoke Employee's overloaded constructor");
        System.out.println("(3) Performs Employee's tasks");
    }
    public Employee(String s) {
        // here super() is invoked
        System.out.println(s);
    }
}

class Person {
    public Person() {
//        System.out.println("(1) Performs Person's tasks");
    }
    @Override
    public String toString() {
        return "Person";
    }
}