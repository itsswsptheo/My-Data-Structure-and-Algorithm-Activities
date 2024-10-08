import java.util.Scanner;

public class ArrayImplementation {
    public static void main(String[] args) {
        // Get user input for the number of elements in the array
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scan.nextInt();

        // Declare the array
        int[] arr = new int[n];

        // Get user input to populate the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        // Print the elements of the array
        System.out.println("The elements of the array are:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // Close the scanner
        scan.close();
    }
}
