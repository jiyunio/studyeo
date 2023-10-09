import java.io.*;
import java.util.*;
import java.lang.*;

// queue <= FIFO
class my_Deque {
    private Deque<Integer> deque = new ArrayDeque<>();
    private int result;

    public void my_push_front(int n) {
        deque.addFirst(n);
    }

    public void my_push_back(int n) {
        deque.addLast(n);
    }

    public int my_pop_front() {
        if (!deque.isEmpty()) {
            result = deque.pollFirst();
            return result;
        } else {
            return -1;
        }
    }

    public int my_pop_back() {
        if (!deque.isEmpty()) {
            result = deque.pollLast();
            return result;
        } else {
            return -1;
        }
    }

    public int my_size() {
        return deque.size();
    }

    public int my_empty() {
        if (deque.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int my_front() {
        if (!deque.isEmpty()) {
            result = deque.peekFirst();
            return result;
        } else {
            return -1;
        }
    }

    public int my_back() {
        if (!deque.isEmpty()) {
            result = deque.peekLast();
            return result;
        } else {
            return -1;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        my_Deque my_deque = new my_Deque();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            String command = bf.readLine();
            StringTokenizer st = new StringTokenizer(command);
            int result;

            switch (st.nextToken()) {
                case "push_front":
                    int n = Integer.parseInt(st.nextToken());
                    my_deque.my_push_front(n);
                    break;

                case "push_back":
                    n = Integer.parseInt(st.nextToken());
                    my_deque.my_push_back(n);
                    break;

                case "pop_front":
                    System.out.println(my_deque.my_pop_front());
                    break;

                case "pop_back":
                    System.out.println(my_deque.my_pop_back());
                    break;

                case "size":
                    System.out.println(my_deque.my_size());
                    break;

                case "empty":
                    System.out.println(my_deque.my_empty());
                    break;

                case "front":
                    System.out.println(my_deque.my_front());
                    break;

                case "back":
                    System.out.println(my_deque.my_back());
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}