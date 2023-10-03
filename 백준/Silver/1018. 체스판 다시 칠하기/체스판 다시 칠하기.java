import javax.sound.midi.SysexMessage;
import java.util.*;
import java.io.*;
import java.math.*;

class Chess {
    String first_W = "WBWBWBWB";
    String first_B = "BWBWBWBW";

    public int check_first_W(String[] str, int m, int n) {
        int count = 0;
        int a = 0;
        while (a < 8) {
            for (int i = 0; i < 8; i++) {
                if (m % 2 == 0) { // 짝수 줄일 때 맨 앞 = W
                    if (str[m].charAt(n + i) != first_W.charAt(i)) {
                        count++;
                    }
                } else {
                    if (str[m].charAt(n + i) != first_B.charAt(i)) {
                        count++;
                    }
                }
            }
            m++;
            a++;
        }
        return count;
    }
    public int check_first_B(String[] str, int m, int n) {
        int count = 0;
        int a = 0;
        while (a < 8) {
            for (int i = 0; i < 8; i++) {
                if (m % 2 == 0) {
                    if (str[m].charAt(n + i) != first_B.charAt(i)) {
                        count++;
                    }
                } else {
                    if (str[m].charAt(n + i) != first_W.charAt(i)) {
                        count++;
                    }
                }
            }
            m++;
            a++;
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();
        int N = scan.nextInt(); // M X N 크기의 보드
        int chess_M = M - 8; // 체스 비교 인덱스 시작값
        int chess_N = N - 8;
        Chess chess = new Chess();

        String[] str = new String[M];
        for (int i = 0; i < M; i++) {
            str[i] = scan.next();
        }

        int count = 64;
        for (int i = 0; i <= chess_M; i++) {
            for (int j = 0; j <= chess_N; j++) {
                int c_w = chess.check_first_W(str, i, j);
                int c_b = chess.check_first_B(str, i, j);
                int c = Math.min(c_w, c_b);
                count = Math.min(c, count);
            }
        }

        System.out.println(count);

    }
}