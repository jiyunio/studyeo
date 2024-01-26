import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();

        Queue<Integer> index_x = new LinkedList<>();
        Queue<Integer> index_y = new LinkedList<>();
        // 지금 볼 토마토들
        int nomato = 0;
        int[][] tomato = new int[b][a];
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                tomato[i][j] = scan.nextInt();
                if (tomato[i][j] == 1) {
                    index_y.add(i);
                    index_x.add(j);
                }
                if (tomato[i][j] == 0) { // 안 익은 토마토 개수 세기
                    nomato++;
                }
            }
        }

        Queue<Integer> move_x = new LinkedList<>();
        Queue<Integer> move_y = new LinkedList<>();
        // 이후에 갈 토마토들

        int result = 0;
        int check_nomato = 0;

        while (!index_y.isEmpty() || !move_x.isEmpty()) {
            int check = 0;
            if (index_y.isEmpty()) { //  현재 갈 곳 X
                while (!move_x.isEmpty()) { // 현재 갈 곳 채워주기
                    index_x.add(move_x.poll());
                    index_y.add(move_y.poll());
                }
            } else { // 현재 갈 곳 O
                while (!index_y.isEmpty()) {
                    int x = index_x.poll();
                    int y = index_y.poll();
                    for (int i = 0; i < 4; i++) {
                        if (x + dx[i] > -1 && x + dx[i] < a && y + dy[i] > -1 && y + dy[i] < b) {
                            if (tomato[y + dy[i]][x + dx[i]] == 0) {
                                tomato[y + dy[i]][x + dx[i]] = 1;
                                move_x.add(x + dx[i]);
                                move_y.add(y + dy[i]);
                                check++;
                                check_nomato++;
                            }
                        }
                    }

                }
                if (check != 0) {
                    result++;
                }
            }
        }

        if (nomato == check_nomato) System.out.println(result);
        else System.out.println("-1");
    }
}