import java.util.Scanner;

class Main {
    static int[] lst = new int[10001];
    static int max_money;

    public static void binarySearch(int s, int e, int m, int sum) {
        if (e - s == 1) {
            max_money = s;
        } else {
            int mid = (s + e) / 2;
            int result = 0;
            int i = 0;
            while (lst[i] != 0) {
                result += Math.min(lst[i], mid);
                i++;
            }

            if (result > m) {
                binarySearch(s, mid, m, sum);
            } else if (result == m) {
                max_money = mid;
            } else {
                if(sum <= result) {
                    sum = result;
                    max_money = mid;
                }
                binarySearch(mid, e, m, sum);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            lst[i] = scan.nextInt();
            sum += lst[i];
        }
        int m = scan.nextInt(); // 총 예산
        if (sum <= m) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, lst[i]);
            }
            System.out.println(max);
        } else {
            binarySearch(0, m, m, 0);
            System.out.println(max_money);
        }
    }
}