/**
 * Edward Reyes
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class Project2 {
    public static void main(String[] args) throws Exception{
        URL path = Project2.class.getResource("input2.txt");
        System.out.println(path.getFile());

        // Get input file
        BufferedReader reader = new BufferedReader(new FileReader(path.getFile()));

//        File file = new File(path.getFile());
//        Scanner input =  new Scanner(file);

        ArrayList<Integer> iValues = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<Integer> momNumbers = new ArrayList<Integer>();

        // Get the first line
        String firstLine = reader.readLine();

        // Get rest of lines
        String lineN = "";
        String line = "";
        while ((line = reader.readLine()) != null) {
                lineN += line + " ";
        }
        System.out.println(firstLine);
        System.out.println(lineN);

        // Store i values into array
        String[] lineString = firstLine.split(" ");
        for (int i = 0; i < lineString.length; i++) {
            iValues.add(Integer.parseInt(lineString[i]));
        }

        // Store numbers into array
        lineString = lineN.split(" ");
        for (int i = 0; i < lineString.length; i++) {
            numbers.add(Integer.parseInt(lineString[i]));
        }

        // Create a second numbers array for quicksort
        int[] numbersQuicksort = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            numbersQuicksort[i] = numbers.get(i);
        }

        // Create a third array for Medians of Medians
        for (int i = 0; i < numbers.size(); i++) {
            momNumbers.add(numbers.get(i));
        }

        findIth(iValues.get(0), numbers, numbersQuicksort);
    }

    static void findIth(int iValue, ArrayList<Integer> numbers, int[] numbersQuicksort) {
        // 1. Sort the integers (maybe with a built in sort).
        Collections.sort(numbers);
        for(int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();
        // Return item at position i
        int ithValue = numbers.get(iValue);
        System.out.println("Sort finds " + ithValue + ".");


        // 2. Use the natural variant of quick sort.
        int n = numbersQuicksort.length;
        QuickSort ob = new QuickSort();
        ob.sort(numbersQuicksort, 0, n-1);
        System.out.println("Quick finds " + numbersQuicksort[iValue] + ".");

        // 3. Use the median of medians method.
        int mom = ithItem(iValue, numbers.size(), numbers);
        System.out.println("MOM finds: " + mom + ".");

    }

    /* A utility function to print array of size n */
    public void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Medians of Medians
    static int ithItem(int i, int N, ArrayList<Integer> data) {
        int answer, mom, j=0, k=0, l;
        int[] medians, smaller, larger;
        ArrayList<Integer> smallerList = new ArrayList<Integer>();
        ArrayList<Integer> largerList = new ArrayList<Integer>();
        ArrayList<Integer> mediansTempArray = new ArrayList<Integer>();
        ArrayList<Integer> mediansList = new ArrayList<Integer>();
        if (N < 50) {
            Collections.sort(data);
            answer = data.get(i);
        }
        else {
            medians = new int[N/5];
            smaller = new int[N];
            larger = new int[N];
            for (l = 0; l < N/5; l++) {
                int count = 0;
                while (count < 4) {
                    mediansTempArray.add(data.get(5 * l + count));
                }
                medians[l] = findMedian(mediansTempArray, mediansTempArray.size());
            }
            // Convert medians to ArrayList
            for (l = 0; l < medians.length; l++) {
                mediansList.add(medians[l]);
            }
            mom = ithItem(N/10, N/5, mediansList);
            for (l = 0; l < N; l++) {
                if (data.get(l) <= mom) {
                    smallerList.add(data.get(l));
                    j++;
                }
                else
                    largerList.add(data.get(l));
                    k++;
            }
            if (i < j) {
                answer = ithItem(i, j, smallerList);
            }
            else {
                answer = ithItem(i-j, k, largerList);
            }
        }
        return answer;
    }

    // Function for calculating median
    public static int findMedian(ArrayList<Integer> a, int n)
    {
        // First we sort the array
        Collections.sort(a);

        // check for even case
        if (n % 2 != 0)
            return a.get(n / 2);

        return ((a.get(n-1) / 2) + (a.get(n/2) / 2));
    }
}

class QuickSort {
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int low, int high) {
        if (low < high) {
            // pi is partitioning index
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
}

