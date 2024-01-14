import javax.swing.text.Style;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> result = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            q.add(scan.nextInt());
        }

        while (!q.isEmpty()) {
            if (result.isEmpty()) {
                result.add(q.poll());
            } else {
                result.add(q.poll() * (result.size() + 1));
            }
        }
        System.out.println(result.peek());
    }
}