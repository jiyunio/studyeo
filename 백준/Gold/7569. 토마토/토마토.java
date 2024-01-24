import java.nio.file.Path;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        Queue<Integer> index_x = new LinkedList<>();
        Queue<Integer> index_y = new LinkedList<>();
        // 지금 볼 토마토들
        int nomato = 0;
        int[][] tomato = new int[b * c][a];
        for (int i = 0; i < b * c; i++) {
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

                    if (x + 1 < tomato[y].length && tomato[y][x + 1] == 0) { // 오른쪽
                        tomato[y][x + 1] = 1;
                        move_x.add(x + 1);
                        move_y.add(y);
                        check++;
                        check_nomato++;
                    }
                    if (x - 1 > -1 && tomato[y][x - 1] == 0) { // 왼쪽
                        tomato[y][x - 1] = 1;
                        move_x.add(x - 1);
                        move_y.add(y);
                        check++;
                        check_nomato++;
                    }

                    if (c > 1) { // 2층 이상
                        if (y + b < tomato.length && tomato[y + b][x] == 0) { // 위
                            tomato[y + b][x] = 1;
                            move_x.add(x);
                            move_y.add(y + b);
                            check++;
                            check_nomato++;
                        }
                        if (y - b > -1 && tomato[y - b][x] == 0) { // 아래
                            tomato[y - b][x] = 1;
                            move_x.add(x);
                            move_y.add(y - b);
                            check++;
                            check_nomato++;
                        }
                        if (y % b != b - 1 && tomato[y + 1][x] == 0) { // 앞
                            tomato[y + 1][x] = 1;
                            move_x.add(x);
                            move_y.add(y + 1);
                            check++;
                            check_nomato++;
                        }
                        if (y % b != 0 && tomato[y - 1][x] == 0) { // 뒤
                            tomato[y - 1][x] = 1;
                            move_x.add(x);
                            move_y.add(y - 1);
                            check++;
                            check_nomato++;
                        }

                    } else { // 1층
                        if (y + 1 < tomato.length && tomato[y + 1][x] == 0) { // 앞
                            tomato[y + 1][x] = 1;
                            move_x.add(x);
                            move_y.add(y + 1);
                            check++;
                            check_nomato++;
                        }
                        if (y - 1 > -1 && tomato[y - 1][x] == 0) { // 뒤
                            tomato[y - 1][x] = 1;
                            move_x.add(x);
                            move_y.add(y - 1);
                            check++;
                            check_nomato++;
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