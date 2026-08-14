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

        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                sb = new StringBuilder();        
                sb.append(String.valueOf(board[i][j]));
                boolean[][] visited = new boolean[n][m];
                visited[i][j] = true;

                dfs(i, j, visited);
                
                if(result) {
                    return true;
                }
            }
        }

        return false;
    }
    
    public void dfs(int x, int y, boolean[][] visited) {
        if(sb.length() > word.length()) return;

        if(sb.toString().equals(word)) {
            result = true;
            return;
        }

        for(int i = 0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < n && ny < m && nx >= 0 && ny >= 0 && !visited[nx][ny]) {
                String s = String.valueOf(board[nx][ny]);

                sb.append(s);
                visited[nx][ny] = true;
                dfs(nx, ny, visited);

                //백트래킹
                visited[nx][ny] = false;
                sb.deleteCharAt(sb.length()-1); //마지막 문자열 지우기
            }
        }
    }
}