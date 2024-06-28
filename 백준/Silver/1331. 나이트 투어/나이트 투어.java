import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] chess = new int[7][7]; // visit 확인용
    static int count = 0;
    static String start;
    static String before;
    static String now;
    static int[] d_fir = new int[]{2, -2};
    static int[] d_sec = new int[]{1, -1};

    public static boolean checkLocation(String s, String e) {
        int n_e = e.charAt(1) - '0';
        int m_e = e.charAt(0) - 'A' + 1;

        int n_s = s.charAt(1) - '0';
        int m_s = s.charAt(0) - 'A' + 1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (n_e + d_fir[i] == n_s && m_e + d_sec[j] == m_s) {
                    return true; // 이동 가능
                }
                if (n_e + d_sec[i] == n_s && m_e + d_fir[j] == m_s) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        start = br.readLine();
        int n = start.charAt(1) - '0'; // 행
        int m = start.charAt(0) - 'A' + 1; // 열
        chess[n][m] = 1;
        count++;

        before = start;
        for (int i = 0; i < 35; i++) {
            now = br.readLine();
            n = now.charAt(1) - '0'; // 행
            m = now.charAt(0) - 'A' + 1; // 열
            if (!checkLocation(before, now) || chess[n][m] == 1) {
                System.out.println("Invalid");
                return;
            }
            chess[n][m] = 1;
            count++;
            before = now;
        }
        if (count == 36 && checkLocation(start, now)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}