import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] result = new int[n + 1];
        Arrays.fill(result, 100000);

        for (int i = 1; i < n + 1; i++) {
            int c = 1;
            while (Math.pow(c, 2) <= n) {
                int p = (int) Math.pow(c, 2);
                if (i == p) result[i] = 1;
                else if (i > p) {
                    result[i] = Math.min(result[i - p] + 1, result[i]);
                }
                c++;
            }
        }
        System.out.println(result[n]);
    }
}