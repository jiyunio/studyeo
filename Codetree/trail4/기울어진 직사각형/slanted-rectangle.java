import java.util.*;
import java.io.*;

/*
순서 : 1->2->3->4
진행 : 대각선 방향
조건 : 모든 방향을 최소 1번씩은 이동해야 함
출력 : 기울어진 직사각형의 합 중 최댓값


*/

public class Main {
    public static int[] dx = {-1, -1, 1, 1};
    public static int[] dy = {1, -1, -1, 1};
    public static int n;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max_score = 0;
        for(int i = 0; i<n; ++i) {
            for(int j = 0; j<n; ++j) {
                
                for(int w = 1; w<n; ++w) {
                    for(int h = 1; h<n; ++h) {
                        max_score = Math.max(max_score, getScore(i, j, w, h));
                    }
                }
            }
        }
        
        System.out.println(max_score);
    }

    public static int getScore(int x, int y, int w, int h) {
        int score = 0;
        int[] size = {w, h, w, h}; //1 -> 2 -> 3 -> 4 의 크기

        for(int i = 0; i<4; ++i) {
            for(int j = 0; j<size[i]; ++j) {
                x += dx[i];
                y += dy[i];

                if(x < 0 || x >= n || y < 0 || y >= n) return 0;

                score += map[x][y];
            }
        }

        return score;
    }
}