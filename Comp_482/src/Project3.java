import java.util.Scanner;

/**
 * Edward Reyes
 *
 * Comp 482 Project 3
 *
 * Idea:
 * You have
 * i
 * eggs and a tower with
 * n
 * increasing height windows.  Assume someone needs to find the highest
 * window where he can safely drop an egg.  One way to solve the problem is to drop an egg out of window 1, if the
 * egg doesn’t break retrieve it and drop from window 2, if the egg doesn’t break retrieve it and drop from window 3,
 * etc.  But as shown in class there are better ways, if you have more than 1 egg.  Judge an algorithm by the worst case
 * of number of times an egg is dropped.
 * The goal of your program is to accept
 * i
 * and
 * n
 * as input and then find the best (ie least cost of any algorithm) using
 * dynamic programming.
 * Input Format:
 * The input comes from the command line, see the interaction below.
 * Output:
 * The output is printed to the screen, see the interaction below
 */
public class Project3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask user for number of eggs
        System.out.print("How many eggs? ");
        int eggs = input.nextInt();

        // Ask user for how many windows
        System.out.print("How many windows? ");
        int windows = input.nextInt();

        // Matrix to create a table to represent tower
        int[][] tower = new int[eggs + 1][windows + 1];


        // All instances of eggs
        for(int i = 1; i <= eggs; i++) {
            // For each window
            for (int j = 0; j <= windows; j++) {
                /**
                 * 0 floors means we need 0 drops
                 * 1 floor means we need 1 drop
                 * 1 egg means we need j drops
                 */
                if(j == 0 || j == 1 || i == 1) {
                    tower[i][j] = j;
                }
                else {
                    int answer = Integer.MAX_VALUE;
                    /**
                     * Make a drop from the kth windows
                     */
                    for (int k = 1; k <= j; k++) {
                        // tower[i - 1][k - 1] means the egg broke on current window
                        // the second param tower[i][j - k] means the egg didn't break
                        int value = 1 + Math.max(tower[i - 1][k - 1], tower[i][j - k]);
                        // Get the next best drop
                        if(answer > value) {
                            answer = value;
                        }
                    }
                    tower[i][j] = answer;
                }
            }
        }
        int highestWindow = tower[eggs][windows];

        // Return answer
        System.out.println("The answer is " + highestWindow + ".");
    }

}
