import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] dp = new int[n + 1][3];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + scan.nextInt();
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + scan.nextInt();
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + scan.nextInt();
        }

        System.out.println(Math.min(Math.min(dp[dp.length - 1][0], dp[dp.length - 1][1]), dp[dp.length - 1][2]));
    }
}