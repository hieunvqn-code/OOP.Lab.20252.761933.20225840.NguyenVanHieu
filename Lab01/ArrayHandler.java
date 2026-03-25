import java.util.Scanner;
import java.util.Arrays;

public class ArrayHandler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        double[] myArray = new double[n];


        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            myArray[i] = sc.nextDouble();
        }


        System.out.println("\nOriginal array: " + Arrays.toString(myArray));


        Arrays.sort(myArray);
        System.out.println("Sorted array: " + Arrays.toString(myArray));


        double sum = 0;
        for (double num : myArray) {
            sum += num;
        }
        double average = sum / n;


        System.out.println("\nSum of array elements: " + sum);
        System.out.println("Average value of array elements: " + average);

        sc.close();
    }
}