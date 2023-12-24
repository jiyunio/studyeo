import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int su_loc = scan.nextInt();
        int d_loc = scan.nextInt();
        int[] lst = new int[100001]; // 걸린 시간 넣는 리스트
        int[] check = new int[100001]; // 방문 체크 리스트
        Queue<Integer> queue = new LinkedList<>();
        queue.add(su_loc);
        check[su_loc] = 1;

        int cur_loc;
        if (su_loc == d_loc) { // 둘의 위치가 같으면 이동할 필요 X
            System.out.println(0);
        } else {
            while (lst[d_loc] == 0) { // 가장 처음으로 동생의 위치에 해당하는 리스트에 값이 적혀지면 그게 최소값임
                cur_loc = queue.poll();
                if (cur_loc - 1 >= 0 && cur_loc - 1 <= 100000) { // 해당 값이 범위 안에 존재
                    if (check[cur_loc - 1] == 0) { // 지나간 값이 아님
                        queue.add(cur_loc - 1);
                        lst[cur_loc - 1] = lst[cur_loc] + 1;
                        check[cur_loc - 1] = 1;
                    }
                }
                if (cur_loc + 1 >= 0 && cur_loc + 1 <= 100000) {
                    if (check[cur_loc + 1] == 0) {
                        queue.add(cur_loc + 1);
                        lst[cur_loc + 1] = lst[cur_loc] + 1;
                        check[cur_loc + 1] = 1;
                    }
                }

                if (cur_loc * 2 >= 0 && cur_loc * 2 <= 100000) {
                    if (check[cur_loc * 2] == 0) {
                        queue.add(cur_loc * 2);
                        lst[cur_loc * 2] = lst[cur_loc] + 1;
                        check[cur_loc * 2] = 1;
                    }
                }
            }
            System.out.println(lst[d_loc]);
        }
    }
}