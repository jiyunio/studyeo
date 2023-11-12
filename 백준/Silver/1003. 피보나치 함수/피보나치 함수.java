import java.io.*;
import java.util.Scanner;

class Fibo {
    int[] lst = new int[40];
    int[] count = new int[41];

    public int fibo(int n) {
        if (n == 0) {
            return 0;
        } else {
            int index = n - 1;
            lst[0] = 1;

            if (lst[index] != 0) { // 값 존재 O
                return lst[index];
            } else { // 값 존재 X
                lst[index] = fibo(n - 1) + fibo(n - 2);
                return lst[index];
            }
        }
    }

    public int count_oneAndzero(int n) {
        if (n == 0) {
            return 1;
        }
        else if(n == 1) {
            return 1;
        }
        else {
            count[0] = count[1] = 1;
            if (count[n] != 0) {
                return count[n];
            } else {
                count[n] = count_oneAndzero(n - 1) + count_oneAndzero(n - 2);
                return count[n];
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Fibo fi = new Fibo();
        int t = scan.nextInt();
        int n;
        int result_zero;
        int result_one;

        for (int i = 0; i < t; i++) {
            n = scan.nextInt();
            result_one = fi.fibo(n);
            result_zero = fi.count_oneAndzero(n) - result_one;
            System.out.println(result_zero + " " + result_one);
        }
    }
}