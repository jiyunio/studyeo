import javax.swing.text.Style;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] lst = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            lst[i] = scan.nextInt();
        }

        for (int i = 0; i < lst.length; i++) {
            int sum = lst[i];
            if(sum == m) {
                count++;
                continue;
            }
            for (int j = i + 1; j < lst.length; j++) {
                sum += lst[j];
                if(sum == m) count++;
                if(sum > m) break;
            }
        }

        System.out.println(count);
    }
}