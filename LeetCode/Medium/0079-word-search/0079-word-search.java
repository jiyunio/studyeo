import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int n;
    static int m;
    static String word;
    static char[][] board;
    static StringBuilder sb = new StringBuilder();
    static boolean result;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        this.word = word;
        this.board = board;
        result = false;

        if(word.length() > n*m) return false;

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] != word.charAt(0)) {
                    continue;
                }

                boolean[][] visited = new boolean[n][m];
                visited[i][j] = true;

                if (dfs(i, j, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
    
    public boolean dfs(int x, int y, int index, boolean[][] visited) {

        if (index == word.length() - 1) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            if (visited[nx][ny]) {
                continue;
            }

            if (board[nx][ny] != word.charAt(index + 1)) {
                continue;
            }

            visited[nx][ny] = true;

            if (dfs(nx, ny, index + 1, visited)) {
                return true;
            }

            visited[nx][ny] = false;
        }

        return false;
    }
}