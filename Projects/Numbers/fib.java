import java.util.Scanner;

public class fib {
    public static void main(String[] args) {
        if (args.length  != 1) {
            System.out.println("Usage: java Fibonacci <n>");
            System.exit(1);

            int n = Integer.parseInt(args[0]);
            if(n < 0){
                System.out.println("n must be a non-negative integer");
                System.exit(1);
            }
            long a = 0;
            long b = 1;
            for (int i=0 ;i<n ;i++) {
                System.out.println("Fibonacci(" + i +") = " + a);
                long temp = a;
                a = b;
                b = temp + b;
            }
    }
}
}