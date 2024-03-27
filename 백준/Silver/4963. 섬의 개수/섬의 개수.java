import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    static int x;
    static int y;
    static int result = 0; // 총 섬의 개수

    static int bfs(int n, int m) {
        for (int i = 0; i < dx.length; i++) {
            map[n][m] = 0; // 현지 섬 방문표시
            int midX = n + dx[i];
            int midY = m + dy[i];
            if (midX < y && midX >= 0 && midY < x && midY >= 0) {
                if (map[midX][midY] == 1) { // 주변에 섬이 있다면
                    bfs(midX, midY);
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            if (x == 0 && y == 0) break;
            else {
                map = new int[y][x];
                for (int i = 0; i < y; i++) {
                    st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < x; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                for (int i = 0; i < y; i++) {
                    for (int j = 0; j < x; j++) {
                        if (map[i][j] == 1) {
                            result += bfs(i, j);

                        }
                    }
                }
                System.out.println(result);
                result = 0;
            }
        }
    }
}
