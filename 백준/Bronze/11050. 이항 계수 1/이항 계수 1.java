import java.io.*;
import java.util.*;
import java.math.*;

class Calculator {
    public int factorial(int n, int k) {
        k = Math.min(n-k, k);
        int result = 1;

        if (n == k || k == 0) {
            return 1;
        } else {
            for (int i = 0; i < k; i++) {
                result = result * (n-i) / (i+1);
            }
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Calculator cal = new Calculator();
        int N = scan.nextInt();
        int K = scan.nextInt();

        System.out.println(cal.factorial(N,K));
    }
}