import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] lst;

    static void makeMax() {
        for (int i = 2; i < n + 1; i++) {
            lst[1][i] = Math.max(lst[1][i] + lst[2][i - 1], lst[1][i] + lst[2][i - 2]);
            lst[2][i] = Math.max(lst[2][i] + lst[1][i - 1], lst[2][i] + lst[1][i - 2]);
        }
        System.out.println(Math.max(lst[1][n], lst[2][n]));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            lst = new int[4][n + 2];
            for (int[] a : lst) Arrays.fill(a, 0);
            for (int j = 1; j < 3; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k < n + 1; k++) {
                    lst[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            makeMax();
        }
    }
}