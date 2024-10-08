import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        // Get user input for the word to check
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = scan.nextLine();

        // Check if the word is a palindrome
        if (isPalindrome(word)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }

        scan.close();
    }

    // Method to check if a word is a palindrome
    public static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }
        return true; // It is a palindrome
    }
}
