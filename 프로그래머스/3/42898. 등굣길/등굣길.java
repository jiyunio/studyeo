import java.util.*;

/*
dp는 누적상태 : 뭐를 누적시킬 것이냐 -> 경로 개수

*/

class Solution {
    int[] dx = {1, 0};
    int[] dy = {0, -1};
    public int solution(int m, int n, int[][] puddles) {
        //0 : 길 | -1 : 웅덩이
        int[][] maps = new int[m][n];
        for(int[] p : puddles) {
            if(p.length == 0) continue;
            int x = p[0]-1;
            int y = p[1]-1;
            maps[x][y] = -1;
        }
        
        int[][] dp = new int[m][n];
        dp[0][0] = 1;        
        
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(maps[i][j] == -1 || (i==0 && j==0)) continue; //웅덩이 또는 집은 패스
                
                if(i-1 >= 0 && j-1 >= 0) {
                    dp[i][j] = (int) ((dp[i][j-1] + dp[i-1][j]) % 1000000007L); //dp[웅덩이]는 무조건 0 => 반영이 안되니 괜찮다
                }
                else if(i-1 < 0 && j-1 >= 0) { //세로 테두리
                    dp[i][j] = dp[i][j-1];
                } else if(i-1 >= 0 && j-1 < 0) { //가로 테두리
                    dp[i][j] = dp[i-1][j];
                }
                //System.out.printf("x : %d | y : %d | dp : %d\n", i, j, dp[i][j]);
            }
        }
        
        return dp[m-1][n-1];
    }
}