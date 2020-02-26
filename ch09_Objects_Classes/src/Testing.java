import java.util.Random;

public class Testing {
    public static void main(String[] args) {
        Random random1 = new Random(4);
        System.out.print("from random: ");
        for (int i = 0; i < 10; i++)
            System.out.print(random1.nextInt(1000) + " ");
    }
}

class A {
    int i = 5;
    static int k = 2;

    public static void main(String[] args) {
        A a = new A();
        int j = a.i;
        a.m1(); // a.i cann access object's instance variable.
    }

    public void m1() {
        i = i + k + m2(i, k);
    }

    public static int m2(int i, int j) {
        return (int)(Math.pow(i, j));
    }
}
