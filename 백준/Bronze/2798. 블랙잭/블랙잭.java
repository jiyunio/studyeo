import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        Vector<Integer> v = new Vector<>();

        for (int i = 0; i < N; i++) {
            v.add(scan.nextInt());
        }

        int sum = 0;
        int gap = M;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    sum = v.get(i) + v.get(j) + v.get(k);
                    if (sum <= M) {
                        gap = Math.min(gap, M - sum);
                    }
                }
            }
        }
        System.out.println(M - gap);
    }
}