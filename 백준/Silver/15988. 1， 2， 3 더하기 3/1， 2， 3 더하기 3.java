import java.util.Scanner;

class Main {
    static Long[] lst = new Long[1000001];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        lst[1] = 1L;
        lst[2] = 2L;
        lst[3] = 4L;
        int y = 4; // dp 채울 인덱스

        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            while (x >= y) {
                lst[y] = (lst[y - 1] + lst[y - 2] + lst[y - 3]) % 1000000009L;
                y++;
            }
            System.out.println(lst[x]);
        }

    }
}