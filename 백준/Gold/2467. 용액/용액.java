import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] solution;
    static int startResult;
    static int endResult;
    static long result = 2000000000;

    static void twoPointer() {
        int start = 0;
        int end = solution.length - 1;

        while (start < end) {
            long midResult = solution[start] + solution[end];
            if (Math.abs(midResult) < result) {
                result = Math.abs(midResult);
                startResult = start;
                endResult = end;
            }

            if (midResult < 0) start++;
            else if (midResult > 0) end--;
            else break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        solution = new long[Integer.parseInt(st.nextToken())];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < solution.length; i++) {
            solution[i] = Long.parseLong(st.nextToken());
        }
        twoPointer();

        System.out.println(solution[startResult] + " " + solution[endResult]);
    }
}