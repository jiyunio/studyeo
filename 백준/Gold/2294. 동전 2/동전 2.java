import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        int[] result = new int[t + 1];
        Arrays.fill(result, 100000);

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < t + 1; i++) {
            for (int j = 0; j < n; j++) {
                if (i == num[j]) result[i] = 1;
                else if (i > num[j]) {
                    result[i] = Math.min(result[i - num[j]] + 1, result[i]);
                }
            }
        }
        System.out.println(result[t] != 100000 ? result[t] : -1);
    }
}