public class Fibonacci {

    // Function to calculate Fibonacci numbers iteratively
    public static long fibonacciIterative(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid input. Please enter a positive integer.");
        } else if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            long a = 0, b = 1;
            for (int i = 3; i <= n; i++) {
                long temp = b;
                b = a + b;
                a = temp;
            }
            return b;
        }
    }

    // Function to calculate Fibonacci numbers recursively
    public static long fibonacciRecursive(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid input. Please enter a positive integer.");
        } else if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Fibonacci <position>");
            System.exit(1);
        }

        try {
            // Parse the command-line argument
            int position = Integer.parseInt(args[0]);

            // Calculate and print Fibonacci number using iterative approach
            long resultIterative = fibonacciIterative(position);
            System.out.println("Fibonacci number at position " + position + " (iterative): " + resultIterative);

            // Calculate and print Fibonacci number using recursive approach
            long resultRecursive = fibonacciRecursive(position);
            System.out.println("Fibonacci number at position " + position + " (recursive): " + resultRecursive);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid positive integer.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
