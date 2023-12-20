import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Map<Integer, PriorityQueue<Integer>> m = new TreeMap<>();
        // key = end, value = start
        int count = 0;
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) { // 시간 입력받기
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            // 내림차순으로 value 저장
            int s = scan.nextInt();
            int e = scan.nextInt();
            if (m.containsKey(e)) {
                pq = m.get(e);
                pq.add(s);
                m.put(e, pq);
            } else {
                pq.add(s);
                m.put(e, pq);
            }
        }
        int k; // 끝나는 시간
        int v; // 시작시간
        int pre = 0; // 이전 회의의 끝나는 값
        Iterator<Integer> keys = m.keySet().iterator();
        while (keys.hasNext()) { // 모든 key값 (끝나는 시간)
            k = keys.next();
            Iterator<Integer> values = m.get(k).iterator(); // key에 해당하는 value값
            while (values.hasNext()) { // 같은 key값에 대한 모든 value값 (시작하는 시간)
                v = values.next();
                if(k == v){ // 끝 == 시작
                    if(pre == k) count++; // 이미 지나가고 있는 key
                    else { // 처음 지나가는 key
                        count++;
                        pre = k;
                    }
                }
                else{ // 끝 != 시작
                    if(pre <= v && pre != k){ // 같은 키값에 대해 한번만 이 곳에 들릴 수 있도록 pre != k 조건을 넣음
                        pre = k; // 끝나는 시간을 현재 key값 넣기
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}