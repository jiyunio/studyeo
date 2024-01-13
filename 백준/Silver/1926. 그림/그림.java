import javax.swing.text.Style;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Main {

    static int count = 0;
    public static int drawing(int[][] lst, int[][] v, int n, int m) { // 그림 크기 구하기
        if (lst[n][m] == 1 && v[n][m] == 0) {
            v[n][m] = 1;
            count++;
            if (m + 1 < lst[n].length && lst[n][m + 1] == 1 && v[n][m + 1] == 0) {
                drawing(lst, v, n, m + 1);
            }
            if (n + 1 < lst.length && lst[n + 1][m] == 1 && v[n + 1][m] == 0) {
                drawing(lst, v, n + 1, m);
            }
            if (m - 1 >= 0 && lst[n][m - 1] == 1 && v[n][m - 1] == 0) {
                drawing(lst, v, n, m - 1);
            }
            if (n - 1 >= 0 && lst[n - 1][m] == 1 && v[n - 1][m] == 0) {
                drawing(lst, v, n - 1, m);
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // 세로
        int m = scan.nextInt(); // 가로

        int[][] lst = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                lst[i][j] = scan.nextInt();
            }
        }

        int[][] v = new int[n][m];

        int c_drawing = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = drawing(lst, v, i, j);
                if (sum > 0) {
                    result = Math.max(result, sum);
                    count = 0;
                    c_drawing++;
                }
            }
        }
        System.out.println(c_drawing);
        System.out.println(result);
    }
}