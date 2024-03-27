import java.util.Scanner;

public class grade {
    public static void main(String[] args) throws Exception {
        float grade;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input a grade between 0 and 100: ");
        grade = scanner.nextFloat();

        while (grade < 0 || grade > 100) {
            System.out.println("Grade must be between 0 and 100. Please input again: ");
            grade = scanner.nextFloat();
        }

        scanner.close();

        char letter;  

        if (grade >= 90 && grade <= 100) {
            letter = 'A';
        } else if (grade >= 80 && grade < 90) {
            letter = 'B';
        } else if (grade >= 70 && grade < 80) {
            letter = 'C';
        } else if (grade >= 60 && grade < 70) {
            letter = 'D';
        } else {
            letter = 'F';  
        }

        System.out.println("Grade = " + grade);
        System.out.println("Letter = " + letter);
    }
}