import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String s = String.valueOf(n);
        int count = 0;

        for (int i = n - 1; i > 0; i--) {
            s = String.valueOf(Integer.parseInt(s) * i);
            while (s.charAt(s.length() - 1) == '0') {
                s = s.substring(0, s.length() - 1); // 0 지우기
                count++;
            }
            if (s.length() > 3) { // 길이가 3을 넘으면
                s = s.substring(s.length() - 3); //뒤에서 3자리만 데려오기
            }
        }
        System.out.println(count);
    }
}