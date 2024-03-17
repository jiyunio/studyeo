import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] list_A;
    static int[][] list_B;
    static int result = 0;

    static void greedy() {
        for (int i = 0; i < list_A.length; i++) {
            for (int j = 0; j < list_A[0].length; j++) {
                if (list_A[i][j] != list_B[i][j]) {
                    result++;
                    reverse_list(i, j);
                }
            }
        }
    }

    static void reverse_list(int i, int j) {
        if (i + 2 < list_A.length && j + 2 < list_A[0].length) { // 배열값을 뒤집는 범위 확인
            for (int m = 0; m < 3; m++) { // 세로
                for (int n = 0; n < 3; n++) { // 가로
                    if (list_A[i + m][j + n] == 1) list_A[i + m][j + n] = 0;
                    else list_A[i + m][j + n] = 1;
                }
            }
        }
    }

    static int checkSame() {
        for (int i = 0; i < list_A.length; i++) {
            for (int j = 0; j < list_A[0].length; j++) {
                if(list_A[i][j] != list_B[i][j]) return -1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list_A = new int[N][M];
        list_B = new int[N][M];
        String[] split_list;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            split_list = st.nextToken().split("");
            for (int j = 0; j < M; j++) {
                list_A[i][j] = Integer.parseInt(split_list[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            split_list = st.nextToken().split("");
            for (int j = 0; j < M; j++) {
                list_B[i][j] = Integer.parseInt(split_list[j]);
            }
        }

        greedy();
        System.out.println(checkSame());
    }
}