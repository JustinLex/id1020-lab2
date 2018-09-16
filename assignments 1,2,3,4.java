/*
README
A single java class that implements assignments 1-4 for lab 2 through a Selection Sort algorithm
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int[] dataAlreadySorted = { 5, 10, 15, 20, 25, 50, 200, 300, 400, 1000 };
    private static int[] dataBackwards = { 1000, 400, 300, 200, 50, 25, 20, 15, 10, 5};
    private static int[] dataExample = { 1, 2, 4, 3, 5, 0};

    private static final boolean usePresetData = true; //use preset data or accept input from stdin
    private static final int assignment = 4; //affect the output of main() depending on the desired assignment

    public static void main(String[] args) {
        if(usePresetData) {
            if(assignment == 4) System.out.println(countInversions(dataAlreadySorted));
            sortArray(dataAlreadySorted);
            assert Arrays.equals(dataAlreadySorted, new int[]{5,10,15,20,25,50,200,300,400,1000}) || assignment == 2;
            System.out.println(Arrays.toString(dataAlreadySorted));

            if(assignment == 4) System.out.println(countInversions(dataBackwards));
            sortArray(dataBackwards);
            assert Arrays.equals(dataBackwards, new int[]{5,10,15,20,25,50,200,300,400,1000}) || assignment == 2;
            System.out.println(Arrays.toString(dataBackwards));

            if(assignment == 4) System.out.println(countInversions(dataExample));
            sortArray(dataExample);
            assert Arrays.equals(dataAlreadySorted, new int[]{0,1,2,3,4,5}) || assignment == 2;
            System.out.println(Arrays.toString(dataExample));
        }
        else {
            Scanner s = new Scanner(System.in);

            System.out.print("Length of array to be sorted: ");
            int len = s.nextInt();
            int[] input = new int[len];

            for(int i = 0; i < len; i++) {
                System.out.print("integer at position " + i + ": ");
                input[i] = s.nextInt();
            }
            if(assignment == 4) System.out.println(countInversions(dataExample));
            sortArray(input);
            System.out.println(Arrays.toString(input));
        }
    }

    private static void sortArray(int[] arr) {
        //using Selection Sort

        int swaps = 0; //track swaps for assignment 3

        for(int i = 0; i < arr.length; i++) { //iterate over insertion sites
            int smallest = arr[i]; //track smallest number found, init with number currently in site
            int smallestIndex = i;
            for(int j = i+1; j < arr.length; j++) { //compare all numbers from the site and after it to find smallest
                if(arr[j] < smallest) {
                    smallest = arr[j];
                    smallestIndex = j;
                }
            }
            //swap the int in insertion site with the smallest int found
            arr[smallestIndex] = arr[i];
            arr[i] = smallest;
            if(assignment == 3) swaps++;
        }
        if(assignment == 2) { //reorder array back to front so sort is in descending instead of ascending
            for(int i = 0; i < arr.length/2; i++) {
                int newpos = arr.length - (i+1); //translate i into swapped destination
                //swap
                int atNewPos = arr[newpos];
                arr[newpos] = arr[i];
                arr[i] = atNewPos;
            }
        }
        if(assignment == 3) System.out.println("Array sorted with " + swaps + " swaps.");
    }

    private static String countInversions(int[] arr) { //used to print inversions for assignment 4
        StringBuilder sb = new StringBuilder(); // use stringbuilder for efficient string concatination
        for(int i = 0; i < arr.length; i++) { //compare every element with the ones after it to see if they are inverted
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j])
                    sb.append(String.format("[%d,%d, %d,%d] ", i, arr[i], j, arr[j])); //record inversion
            }
        }
        return sb.toString(); //output final string
    }


}
