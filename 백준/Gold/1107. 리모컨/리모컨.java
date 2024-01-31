import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        String str_n = Integer.toString(n);

        ArrayList<Integer> button = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            button.add(scan.nextInt());
        }
        int stayPlma = Math.abs(n - 100);
        int movePlma = stayPlma;

        if (m == 0) { // 모든 값 가능
            movePlma = str_n.length();
            System.out.println(Math.min(movePlma, stayPlma));
        } else if (m == 10) {
            System.out.println(stayPlma);
        } else {
            int max = (int) Math.pow(10, (str_n.length() + 2));
            for (int i = n; i >= 0; i--) {
                String s = Integer.toString(i);
                int check = 0;
                char[] chars = s.toCharArray();
                for (char ch : chars) {
                    if (button.contains(ch - '0')) {
                        check++;
                        break;
                    }
                }
                if (check == 0) {
                    movePlma = s.length() + Math.abs((n - i));
                    break;
                }
            }
            for (int i = n; i <= max; i++) {
                String s = Integer.toString(i);
                int check = 0;
                char[] chars = s.toCharArray();
                for (char ch : chars) {
                    if (button.contains(ch - '0')) {
                        check++;
                        break;
                    }
                }
                if (check == 0) {
                    movePlma = Math.min(movePlma, s.length() + Math.abs((n - i)));
                    break;
                }
            }
            System.out.println(Math.min(movePlma, stayPlma));
        }


    }
}
