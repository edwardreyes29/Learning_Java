public class TestJava {
    public static void main(String[] args) {

        int[] list1 = {2, 4, 7, 10};
        int[] list2 = {2, 4, 7, 7, 7, 10};
        java.util.Arrays.fill(list1, 5);
        java.util.Arrays.fill(list2, 1, 5, 8);
        for (int e: list1) {
            System.out.print(e + " ");
        }
        System.out.println();
        for (int e: list2) {
            System.out.print(e + " ");
        }


//        Scanner input = new Scanner(System.in);
//
//        int[] list = {1, 2, 3, 5, 4};
//
//        for (int i = 0, j = list.length -1; i < list.length; i++, j--) {
//            // Swap list[i[ with list[j]
//            int temp = list[i];
//            list[i] = list[j];
//            list[j] = temp;
//
//        }
//
//        for (int e: list) {
//            System.out.print(e + " ");
//        }
//
//
//
//
//
//
//
//        char[] city = {'D', 'a', 'l', 'l', 'a', 's'};
//        System.out.println(city);
//
//        double[] myList = {1, 5, 3, 4, 5, 5};
//
//        double max = myList[0];
//        int indexOfMax = 0;
//        for (int i = 0; i < myList.length; i++) {
//            if (myList[i] > max) {
//                max = myList[i];
//                indexOfMax = i;
//            }
//        }
//        System.out.println("The largest element is " + max);
//        System.out.println("The smallest index of " + max + " is " + indexOfMax);
//
//        // Randomly shuffling array
//        for (int i = myList.length - 1; i > 0; i--) {
//            // Generate an index j randomly with 0 <= j <= i
//            int j =  (int)(Math.random() * (i + 1));
//            System.out.println(j);
//
//            // Swamp myList[i] with myList[j]
//            double temp = myList[i];
//            myList[i] = myList[j];
//            myList[j] = temp;
//        }
//
//        System.out.println("Array shuffled");
//        for (int i = 0; i < myList.length; i++) {
//            System.out.print(myList[i] + " ");
//        }
//
//        // Shifting elements;
//        double temp = myList[0];
//
//        // Shift elements left
//        for (int i = 1; i < myList.length; i++) {
//            myList[i - 1] = myList[i];
//        }
//
//        // Move the first element to fill in the last position
//        myList[myList.length - 1] = temp;
//
//        System.out.println("Array shifted");
//        for (int i = 0; i < myList.length; i++) {
//            System.out.print(myList[i] + " ");
//        }
//
//        System.out.println();
//
//        // Better than using a lengthy if-else or switch to determine day
//        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
//        System.out.print("Enter a day number (1 to 7) ");
//        int dayNumber = input.nextInt();
//        System.out.println("The day is " + days[dayNumber - 1]);
//
//        // For each loops
//        // For each 'e' in myList, do the following
//        for (String e: days) {
//            System.out.println(e);
//        }
//
//        char[] city2 = new char[city.length];
//        System.arraycopy(city, 0, city2, 0, city.length);
//
//        System.out.println(city2);
//
//


    }
}
