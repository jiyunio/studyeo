import java.util.Scanner;

public class Main {
    static int[] sugar = new int[5001];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        sugar[3] = 1;
        sugar[4] = -1;
        sugar[5] = 1;

        for (int i = 6; i <= N; i++) {
            if (sugar[i - 5] > 0) {
                sugar[i] = sugar[i - 5] + 1;
            } else {
                if (sugar[i - 3] > 0) {
                    sugar[i] = sugar[i - 3] + 1;
                } else {
                    sugar[i] = -1;
                }
            }
        }

        System.out.println(sugar[N]);
    }
}