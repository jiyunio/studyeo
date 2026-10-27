import java.util.*;
import java.io.*;

/*
겹치지 않는 두 개의 직사각형을 고르고
두 직사각형의 총 합 = 최대


하나의 직사각형 고르기
고른 상태에서 다른 직사각형 고르면서 최댓값 갱신시키기

다른 직사각형과 겹치지 않기 위해서는 visited를 이용하며 진행해야 함
*/

public class Main {
    static int n;
    static int m;
    static int[][] grid;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // Please write your code here.
        int max_score = -250000;
        for(int i = 0; i<n; ++i) {
            for(int j = 0; j<m; ++j) {
                int score = Integer.MIN_VALUE;
                for(int w = 1; w<=m; ++w) { //가로 길이 (y와 관련)
                    for(int h = 1; h<=n; ++h) { //세로 길이 (x와 관련)
                        visited = new boolean[n][m]; //방문배열
                        if(!valid(i, j, w, h)) continue;

                        score = getScore(i, j, w, h);
                        
                        boolean[][] tmp = copy(visited);
                        for(int i1 = 0; i1<n; ++i1) {
                            for(int j1 = 0; j1<m; ++j1) {
                                int score1 = Integer.MIN_VALUE;
                                for(int w1 = 1; w1<=m; ++w1) { //가로 길이
                                    for(int h1 = 1; h1<=n; ++h1) { //세로 길이
                                        if(!valid(i1, j1, w1, h1)) continue;
                                        score1 = getScore(i1, j1, w1, h1);

                                        max_score = Math.max(max_score, score + score1); //최댓값 갱신

                                        visited = copy(tmp); //배열 복구
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(max_score);
    }

    public static int getScore(int x, int y, int w, int h) {
        int score = 0;
        for(int i = 0; i<h; ++i) {
            for(int j = 0; j<w; ++j) {
                int nx = x + i;
                int ny = y + j;

                visited[nx][ny] = true;
                score += grid[nx][ny];
            }
        }

        return score;
    }

    public static boolean valid(int x, int y, int w, int h) {
        for(int i = 0; i<h; ++i) {
            for(int j = 0; j<w; ++j) {
                int nx = x + i;
                int ny = y + j;

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) return false;
                if(visited[nx][ny]) return false;
            }
        }

        return true;
    }

    public static boolean[][] copy(boolean[][] arr) {
        boolean[][] result = new boolean[n][m];
        for(int i = 0; i<n; ++i) {
            result[i] = arr[i].clone();
        }

        return result;
    }
}