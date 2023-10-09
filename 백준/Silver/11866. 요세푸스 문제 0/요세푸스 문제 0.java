import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        int N = scan.nextInt();
        int K = scan.nextInt();
        for (int i = 1; i < N + 1; i++) {
            queue.add(i);
        }

        int result = 0;
        int n = 1;
        while (!queue.isEmpty()) {
            if (N == 1 && K == 1) {
                System.out.println("<" + 1 + ">");
                break;
            }
            for (int i = 0; i < K; i++) {
                if (i == K - 1) {
                    result = queue.peek();
                    queue.poll();
                } else {
                    result = queue.peek();
                    queue.poll();
                    queue.add(result);
                }
            }

            if (n == 1) {
                System.out.print("<" + result + ", ");
            } else if (n == N) {
                System.out.print(result + ">");
            } else {
                System.out.print(result + ", ");
            }
            n++;
        }

    }
}