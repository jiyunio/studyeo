import java.io.*;
import java.util.Scanner;

class Check_Napa {
    int[][] check_lst; // 방문 리스트

    public int check_around(int[][] napa, int x, int y, int m, int n) {
        if (x == m || y == n) return 0;
        else {
            if (napa[x][y] == 1) {
                if(check_lst[x][y] == 1) return 0;
                else{ // 방문 안한 곳
                    check_lst[x][y] = 1;
                    check_around(napa, x + 1, y, m, n);
                    check_around(napa, x, y + 1, m, n);
                    if(x > 0) check_around(napa, x-1, y, m, n);
                    if(y > 0) check_around(napa, x, y-1, m, n);
                }
            } else return 0;
        }
        return 1;
    }

    public void set_checklist(int x, int y) {
        check_lst = new int[x][y];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Check_Napa check_napa = new Check_Napa();
        int t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            int m = scan.nextInt(); // 가로 길이 => columns
            int n = scan.nextInt(); // 세로 길이 => rows
            int k = scan.nextInt();
            int[][] napa_cabbage = new int[m][n];
            check_napa.set_checklist(m, n);

            for (int j = 0; j < k; j++) {
                int x = scan.nextInt();
                int y = scan.nextInt();
                napa_cabbage[x][y] = 1;
            }
            int min_earthworm = 0;
            for (int a = 0; a < m; a++) {
                for (int b = 0; b < n; b++) {
                    min_earthworm += check_napa.check_around(napa_cabbage, a, b, m, n);
                }
            }
            System.out.println(min_earthworm);
        }
    }
}