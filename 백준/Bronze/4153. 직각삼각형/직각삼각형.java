import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        Vector<Integer> v = new Vector<>();

        for (int i = 0; i < 3; i++) {
            v.add(scan.nextInt());
        }
        Collections.sort(v); // 마지막이 제일 크도록

        while (v.get(2) != 0 && v.get(1) != 0 && v.get(0) != 0) {
            double a = v.get(0);
            double b = v.get(1);
            double c = v.get(2);
            if (a == 0 && b == 0 && c == 0) break;

            else {
                a = Math.pow(a, 2);
                b = Math.pow(b, 2);
                c = Math.pow(c, 2);
                if (c == (a + b)) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            }

            v.set(0, scan.nextInt());
            v.set(1, scan.nextInt());
            v.set(2, scan.nextInt());
            Collections.sort(v); // 마지막이 제일 크도록
        }

    }
}