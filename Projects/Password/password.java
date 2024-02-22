package Password;

import java.util.Scanner;

public class password {
    public static void main(String[] args) {
        System.out.println("Password validation check!");
        System.out.println("lower case letter, i.e., a-z");
        System.out.println("upper case letters, i.e., A-Z");
        System.out.println("numbers, i.e., 0-9");
        System.out.println("following special symbols: ~!@#$%^&*()-=+_ ");
        
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a password: ");
        String password = scanner.nextLine();

        if (isValid(password)) {
            System.out.println("Valid password");
        } else {
            System.out.println("Invalid password");
        }
        
    }

    public static boolean isValid(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        int lowerCaseCount = 0;
        int upperCaseCount = 0;
        int digitCount = 0;
        int specialCount = 0;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isLowerCase(c)) {
                lowerCaseCount++;
            } else if (Character.isUpperCase(c)) {
                upperCaseCount++;
            } else if (Character.isDigit(c)) {
                digitCount++;
            } else if (isSpecialChar(c)) {
                specialCount++;
            }
        }

        return lowerCaseCount + upperCaseCount + digitCount + specialCount >= 3;
    }

    public static boolean isSpecialChar(char c) {
        String specialChars = "~!@#$%^&*()-=+_";
        return specialChars.indexOf(c) != -1;
    }
}