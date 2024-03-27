package Projects;
import java.util.Scanner;

public class reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the original string: ");
        String originalString = scanner.nextLine();

        String reversedString = reverseString(originalString);

        System.out.println("Original String: " + originalString);
        System.out.println("Reversed String: " + reversedString);
    }

    private static String reverseString(String input) {

        StringBuilder reversedStringBuilder = new StringBuilder(input);

        reversedStringBuilder.reverse();

        return reversedStringBuilder.toString();
    }
}
