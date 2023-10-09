import java.io.*;
import java.util.*;
import java.lang.*;
// queue <= FIFO
class my_Queue {
    private Vector<Integer> v = new Vector<>();
    private int result;

    public void my_push(int n) {
        v.add(n);
    }

    public int my_pop() {
        if (!v.isEmpty()) {
            result = v.get(0);
            v.remove(0);
            return result;
        } else {
            return -1;
        }
    }

    public int my_size() {
        return v.size();
    }

    public int my_empty() {
        if (v.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int my_front() {
        if (!v.isEmpty()) {
            result = v.get(0);
            return result;
        } else {
            return -1;
        }
    }

    public int my_back() {
        if (!v.isEmpty()) {
            result = v.get(v.size()-1); // 마지막 인덱스 정수 꺼내오기
            return result;
        } else {
            return -1;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        my_Queue my_que = new my_Queue();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            String command = bf.readLine();
            StringTokenizer st = new StringTokenizer(command);
            int result;

            switch (st.nextToken()) {
                case "push":
                    int n = Integer.parseInt(st.nextToken());
                    my_que.my_push(n);
                    break;

                case "pop":
                    //bw.write(my_stack.my_pop());
                    System.out.println(my_que.my_pop());
                    break;

                case "size":
                    //bw.write(my_stack.my_size());
                    System.out.println(my_que.my_size());
                    break;

                case "empty":
                    //bw.write(my_stack.my_empty());
                    System.out.println(my_que.my_empty());
                    break;

                case "front":
                    //bw.write(my_stack.my_top());
                    System.out.println(my_que.my_front());
                    break;
                case "back":
                    System.out.println(my_que.my_back());
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}