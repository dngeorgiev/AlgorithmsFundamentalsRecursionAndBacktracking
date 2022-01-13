package recursiveFactorial;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        long factorial = calculateFactorial(n);

        System.out.println(factorial);
    }

    private static long calculateFactorial(int n) {
        if (n == 1) return 1;

        return n * calculateFactorial(n - 1);
    }


}
