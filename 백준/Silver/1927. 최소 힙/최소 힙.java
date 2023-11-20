import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int case_num = Integer.parseInt(br.readLine());
            if(case_num == 0){
                if(queue.isEmpty())
                    bw.write("0\n");
                else {
                    bw.write(String.valueOf(queue.poll() + "\n"));
                }
            }
            else {
                queue.add(case_num);
            }
            bw.flush();
        }
        br.close();
        bw.close();
    }
}