import javax.swing.text.Style;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            t[i] = scan.nextInt() - 1;
            p[i] = scan.nextInt();
        }

        int index = 0; // 정상 인덱스
        int[] lst = new int[n + 1];

        for (int i = n; i > 0; i--) {
            if (index == 0) { // 초기값 설정
                if (i + t[i] <= n) {
                    lst[i] = p[i];
                    index = i;
                }
            } else {
                if (i + t[i] <= n) {
                    if (i + t[i] >= index) {
                        int mid = 0;
                        for (int j = i + t[i] + 1; j <= n; j++) {
                            if (lst[j] != 0) {
                                mid = lst[j];
                                break;
                            }
                        }
                        if (mid + p[i] > lst[index]) {
                            lst[i] = mid + p[i];
                            index = i;
                        }
                    } else {
                        lst[i] = p[i] + lst[index];
                        index = i;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i < lst.length; i++) {
            if(lst[i] != 0){
                result = lst[i];
                break;
            }
        }
        System.out.println(result);
    }
}