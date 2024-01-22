import java.util.Scanner;

class Main {
    static String[] lst = new String[1001];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        lst[1] = "SK";
        lst[2] = "CY";
        lst[3] = "SK";
        lst[4] = "SK";
        int i = 5;
        if (n < i) {
            System.out.println(lst[n]);
        } else {
            while (i <= n) {
                if (lst[i - 1] == "CY" || lst[i - 3] == "CY" || lst[i - 4] == "CY") { // 막턴 전의 상태 == CY
                    lst[i] = "SK";
                } else {
                    lst[i] = "CY";
                }
                i++;
            }
            System.out.println(lst[n]);
        }
    }
}