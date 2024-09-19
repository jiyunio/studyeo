import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String[][] lst = new String[11][21];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i < 11; i++) {
            Arrays.fill(lst[i], ".");
        }
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            int r = s.substring(0, 1).charAt(0) - 64;
            int c = Integer.parseInt(s.substring(1));
            lst[r][c] = "o";
        }

        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 21; j++) {
                System.out.print(lst[i][j]);
            }
            System.out.println();
        }
    }
}