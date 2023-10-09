import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;
import java.math.*;

class Point {
    Vector<Integer> y;

    public void sort_point(TreeMap<Integer, Vector<Integer>> map) {
        for (int key : map.keySet()) {
            y = map.get(key);
            if (y.size() == 1) { // 원소를 하나만 가지고 있을 경우
                System.out.println(key + " " + y.get(0));
            } else {
                Collections.sort(y);
                for (int i = 0; i < y.size(); i++) {
                    System.out.println(key + " " + y.get(i));
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        TreeMap<Integer, Vector<Integer>> map = new TreeMap<>();
        Point point = new Point();

        int N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            int x = scan.nextInt();
            Vector<Integer> y = new Vector<>();

            if (!map.containsKey(x)) { // 처음 넣는 수일 경우
                y.add(scan.nextInt());
                map.put(x, y);
            } else { // 이미 넣은 수인 경우
                y = map.get(x);
                y.add(scan.nextInt());
                map.put(x, y);
            }
        }
        
        point.sort_point(map);

    }
}