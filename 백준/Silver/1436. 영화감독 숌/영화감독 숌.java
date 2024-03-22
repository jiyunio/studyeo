import java.util.Scanner;

public class Main {
    static int movieCount;
    static String result;

    static void shoum() {
        int count = 0;
        for (int i = 666; i <= 10000000; i++) {
            result = Integer.toString(i);
            if (result.contains("666")) {
                count++;
                if (movieCount == count) break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        movieCount = scan.nextInt();
        shoum();

        System.out.println(result);
    }
}