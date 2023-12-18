import javax.swing.plaf.IconUIResource;
import java.awt.image.ImageProducer;
import java.io.*;
import java.util.*;

class MakeOne {
    public int makingOne(int n, int[] lst) { // n : 반복문 시작
        for (int i = n; i < lst.length; i++) {
            int case1 = lst.length;
            int case2 = lst.length;
            int case3 = lst.length;
            if (i % 2 == 0) {
                case2 = lst[i / 2] + 1;
            }
            if (i % 3 == 0) {
                case3 = lst[i / 3] + 1;
            }
            if (i - 1 != 0) {
                case1 = lst[i - 1] + 1;
            }
            lst[i] = Math.min(case3, Math.min(case1, case2));
        }
        return lst[lst.length-1];
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader((System.in)));
        String s = bf.readLine();
        int n = Integer.parseInt(s);
        int[] lst = new int[n + 1];
        lst[1] = 0;
        MakeOne makeOne = new MakeOne();
        if (n >= 3) {
            lst[2] = 1;
            lst[3] = 1;
            System.out.println(makeOne.makingOne(4, lst));
        } else {
            System.out.println(makeOne.makingOne(2, lst));
        }
    }
}