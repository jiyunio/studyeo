import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        while (num != 0) {
            String str_num = Integer.toString(num); // 정수 -> 문자열
            int str_len = str_num.length(); // 문자 길이
            int count = 0;

            if (str_len % 2 == 0) { // 문자길이 = 짝수
                for (int i = 0; i < str_len / 2; i++) {
                    if (str_num.charAt(i) == str_num.charAt(str_len - 1 - i)) {
                        count++;
                    }
                }
            } else { // 문자길이 = 홀수
                for (int i = 0; i < str_len / 2; i++) {
                    if (str_num.charAt(i) == str_num.charAt(str_len - 1 - i)) {
                        count++;
                    }
                }
            }

            if (count == str_len / 2) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
            count = 0;
            num = scan.nextInt();
        }
    }
}