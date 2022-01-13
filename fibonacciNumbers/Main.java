package fibonacciNumbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Map<Integer, Long> fibonacciMemo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        long fibonacciN = getFibonacciNumber(n);

        System.out.println(fibonacciN);
    }

    private static long getFibonacciNumber(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        if (fibonacciMemo.containsKey(n)) {
            return fibonacciMemo.get(n);
        }

        long result = getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
        fibonacciMemo.put(n, result);

        return result;
    }
}
