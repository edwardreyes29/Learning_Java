/**
 * Edward Reyes
 * Comp 482
 * Project 1
 *
 * Notes: my File instances has been set to "input1.txt" It won't read any input unless you change
 * the .txt file to this specific name or change the .txt file name in the program.
 *
 * For this project, I used the Irvings algorithm to solve this problem.
 * There are three stages to this problem.
 * [Stage 1]
 * The first is step is to have each person
 * make a proposal, and they will be accepted if the proposed person has not been proposed yet,
 * or be rejected if the propsed person prefers the person he/she has been proposed by prior.
 * If one person has been rejected by everyone, then no stable matchings exists.
 *
 * This is similar to the G-S Algorithm, but it differs on at stage 2.
 *
 * [Stage 2]
 * Everyone rejects thier potential roommates less desirable than the current roommate
 * that was accepted. Rejections are symmetrical, meaning that if person 2 rejects person 5, person 5
 * must also reject person 2 in return (Pay back I guess)
 *
 * [Stage 3]
 * - Find a participant that has more than one choice
 * - store the id(row) of the person in a list
 * - from there, get that persons 2nd prefernce and store it in another list
 * - from that list, store that persons "last" preference and store it in the previous list
 * - Continue until a cycle is found where the first person in the first list appears again.
 * - Do a diagnoal deletion, so persons it list one of index i are associated with persons in the
 *      the second list index of i - 1;
 * - If there are still lists with more than one preference, go down to the next person and repeat
 *      until each prefernces list is 1.
 *
 * This algorithm doesn't account for finding out the number of different stable matchings. What I've
 * done is, after stage 2, I reorder the process. e.g if order is [1,2,3,4,5] then put in the back of
 * the list [2,3,4,1] and repeat until i got every order. This finds all combinations, though I have no
 * proof to verify it works for all cases.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Project1 {
    public static void main(String[] args) throws Exception{
        File file = new File("input1.txt");
        Scanner input =  new Scanner(file);

        // Get the even number of people from input1.txt
        int n = input.nextInt();

        // Create Multidimensional array to store preference list
        int[][] preferenceList = new int[n][n-1];

        // Create a LinkedList of free candidates who haven't proposed
        LinkedList<Integer> freeList = new LinkedList();
        // Create a Next Array

        // An array that holds true or false if person was accepted
        boolean[][] acceptedList = new boolean[n][n-1];
        // Create another array to keep track of persons proposes.
        boolean[][] proposedList = new boolean[n][n-1];

        // Fill in preferenceList array with the rest of the inputs
        for (int i = 0; i < preferenceList.length; i++) {
            for (int j = 0; j < preferenceList[i].length; j++) {
                preferenceList[i][j] = input.nextInt();
            }
            freeList.add(i, i); // add current i to list
        }

        /*
            Stage 1
            - Everyone propose to their favorites
            - Those propose will either accept if not proposed yet, or pick between the best proposers.
            - If someone gets rejected by everyone else, then no stable matching exists.
         */
        int count = 0;
        boolean rejectAll = false; // If true, then someone got rejected by everyone.
        int index = 0; // Set index to 0, increment when necessary,
        // This loop will end every person has proposed or if a person has been rejected by everyone.
        while(freeList.size() != 0) {

            if (index >= n-1) {
                System.out.println("No");
                rejectAll = true;
                break;
            }

            int acceptedIndex = -1; // keeps track of the index of the roommate a person accepted.
            int freePersonIndex = -1;

            // Get first free person in freeList
            int freePerson = (int)freeList.getFirst();
            int highestRanked = preferenceList[freePerson][index];

            boolean proposed = false;
            // check if this person has been proposed
            for (int i = 0; i < n-1; i++) {
                if (acceptedList[highestRanked - 1][i] == true) {
                    proposed = true;
                    acceptedIndex = i;
                }
                if (preferenceList[highestRanked - 1][i] == (freePerson + 1)) {
                    freePersonIndex = i; // Get persons index for comparison
                }
            }

            // If the highest ranked roommate has not been proposed too, proposed roommate will accept
            // free person's proposal
            if (proposed == false) {
                acceptedList[highestRanked - 1][freePersonIndex] = true;
                // Remove free person from the list since he/she has proposed.
                freeList.pop();
                index = 0;
//                System.out.println("Pop it!"); // Delete
            } else if (acceptedIndex < freePersonIndex) {
                preferenceList[freePersonIndex][index] = -1;
                preferenceList[highestRanked-1][freePersonIndex] = -1; // eliminate this spot

                index++; // go to the free persons next highest ranking preference.

            } else if (acceptedIndex > freePersonIndex) {
                acceptedList[highestRanked - 1][freePersonIndex] = true;
                acceptedList[highestRanked - 1][acceptedIndex] = false;
                freeList.pop(); // Remove the accepted proposal from free list
                freeList.addFirst(freePerson - 1); // Return the index of the rejected person back to the free list.
//                System.out.println("Add First"); // Delete

                preferenceList[highestRanked-1][acceptedIndex] = -1;
                preferenceList[freePersonIndex][index] = -1;


                index++;
            }
        }



        if (rejectAll == true) { // If true, program ends
            System.exit(0);
        } else {

            /*
                Stage 2
                Everyone rejects those potential partners less desirable than
                their current accepted one.
             */

            // Get index of elements in acceptList that are true.
            int[] acceptedListIndexes = new int[n];
            for (int i = 0; i < acceptedList.length; i++) {
                for (int j = 0; j < acceptedList[i].length; j++) {
                    if (acceptedList[i][j] == true) {
                        acceptedListIndexes[i] = j; // works
                    }
                }
            }
//            for (int i = 0; i < acceptedListIndexes.length; i++) {
//                System.out.print(acceptedListIndexes[i] + ", ");
//            }

            // Reject those potential partners less desirable than
            // their current accepted one. Deletions are symmetircal
            for (int row = 0; row < preferenceList.length; row++) {
                for (int col = preferenceList[row].length - 1; col > acceptedListIndexes[row]; col--) {
                    int rejectIndex = preferenceList[row][col] - 1;

                    preferenceList[row][col] = -1;

                    int i = 0;
                    boolean found = false;
                    while(!found && rejectIndex >= 0) {
//                        System.out.println("current comparison " + preferenceList[rejectIndex][i]);
                        if (preferenceList[rejectIndex][i] == (row + 1)) {
                            preferenceList[rejectIndex][i] = -1;
                            found = true;
                        }
                        i++;
                    }
                }
            }

//            System.out.println();
//            for (int i = 0; i < preferenceList.length; i++) { // DELETE
//                for (int j = 0; j < preferenceList[i].length; j++) {
//                    System.out.print(preferenceList[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();


            /*
                Stage Three: Eliminate preference cycles.
             */
            // Try converting array to list.
            ArrayList<LinkedList> aList = new ArrayList<LinkedList>();

            ArrayList<LinkedList> copyArray = new ArrayList<LinkedList>();
            for(int i = 0; i < preferenceList.length; i++) {
                LinkedList list = new LinkedList();
                LinkedList copyList = new LinkedList();
                for (int j = 0; j <= acceptedListIndexes[i]; j++) {
                    if (preferenceList[i][j] != -1){
                        list.add(preferenceList[i][j]);
                        copyList.add(preferenceList[i][j]);
                    }
                }
                aList.add(list);
                copyArray.add(copyList);
            }

            // Create an Array of all stable matches
            int[][] stableMatches = new int[n][n];
            ArrayList<LinkedList> stableMatch = new ArrayList<LinkedList>();

            int stableIndex = 0;
            // Implement Stage 3
            int next = 0;
            for (int index2 = 0; index2 < aList.size(); index2++) {

                next = index2;
                int iteration = 0;
                while(next < n || iteration < n) {
                    if (next >= n && iteration < n) {
                        next = 0;
                    }

                    if (aList.get(next).size() > 1) {
                        int start = 0;

                        int[] secondArray = new int[n * 2];
                        int[] lastArray = new int[n * 2];


                        // Pick second choice
                        int secondChoice = (int)aList.get(next).get(1);
                        int lastChoice = (int)aList.get(secondChoice - 1).getLast();

                        secondArray[start] = next + 1;
                        lastArray[start] = secondChoice;
                        start++;
                        secondArray[start] = lastChoice;

                        while (secondArray[0] != secondArray[start] || start > secondArray.length) {
                            // new second choice
                            secondChoice = (int)aList.get(lastChoice -1).get(1);
                            lastChoice = (int)aList.get(secondChoice - 1).getLast();

                            lastArray[start] = secondChoice;
                            start++;
                            secondArray[start] = lastChoice;

                        }
                        // Remove diagonals
                        int k = start;
                        while(k > 0) {
//                            System.out.println("aList288" + aList);
                            aList.get(secondArray[k] - 1).removeFirstOccurrence((lastArray[k - 1]));
                            aList.get(lastArray[k - 1] - 1).removeFirstOccurrence(secondArray[k]);
                            k--;
                        }
                    }
                    next++;
                    iteration++;
                } // End-while
                // Copy values from this finalized array by creating new array and storing it in stable
                int[] tempArray = new int[n];

                // copy finalized array into new stable array
                for (int i = 0; i < tempArray.length; i++) {
                    tempArray[i] = (int)aList.get(i).get(0);
                }


                for (int i = 0; i < stableMatches[stableIndex].length; i++) {
                    stableMatches[stableIndex][i] = (int)tempArray[i];
                }
                stableIndex++;
//                System.out.println(aList + " state of aList in 274");
                for (int i = 0; i < aList.size(); i++) {
                    boolean removedfirst = false;
//                    System.out.println("i value 280: " + i);
//                    System.out.println(aList.size());
                    for (int j = 0; j < copyArray.get(i).size(); j++) {
                        if (!removedfirst) {
                            aList.get(i).remove(0);
                            removedfirst = true;
                        }

                        aList.get(i).add(j, copyArray.get(i).get(j));

                    }
                }
//                System.out.println("Copy Array 293 swapped: " + copyArray);
//                System.out.println("New ALIST line 290 " + aList);
            }

//            System.out.println("STABLE MATCHES");
//            for (int i = 0; i < stableMatches.length; i++) {
//                for (int j = 0; j < stableMatches[i].length; j++) {
//                    System.out.print(stableMatches[i][j] + " ");
//                }
//                System.out.println();
//            }

            int numberOfStableMatches = 1; // If the program made it this far, there is atleast one.
            boolean isMatch = false;
            // Find total number of stable matchings in array.
            for (int i = 0; i < stableMatches.length; i++) {
                if ((i + 1) >= stableMatches.length) {
                    break;
                }
                isMatch = Arrays.equals(stableMatches[i], stableMatches[i + 1]);
                if (!isMatch) {
                    numberOfStableMatches++;
                }
            }
            System.out.println("Yes " + numberOfStableMatches);

        }

        input.close();
    }


}
