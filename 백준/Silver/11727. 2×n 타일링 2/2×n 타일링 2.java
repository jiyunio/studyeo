import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] lst = new long[n + 1];
        lst[1] = 1;
        if (n == 1) {
            System.out.println(lst[n]);
            return;
        }

        lst[2] = 3;

        for (int i = 3; i < n + 1; i++) {
            lst[i] = (lst[i - 1] + lst[i - 2] * 2) % 10007;
        }
        System.out.println(lst[n]);
    }
}