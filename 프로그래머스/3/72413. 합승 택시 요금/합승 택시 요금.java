import java.util.*;

class Solution {
    static final int INF = 0x7FFFFFFF;
    static final int SIZE = 201;

    static int[][] adjMat = new int[SIZE][SIZE];
    static int ans;

    static void initGlobal() {
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(adjMat[i], INF);
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        initGlobal();

        for (int i = 0; i < fares.length; i++) {
            adjMat[fares[i][0]][fares[i][1]] = fares[i][2];
            adjMat[fares[i][1]][fares[i][0]] = fares[i][2];
        }

        for (int i = 0; i <= n; i++) {
            adjMat[i][i] = 0;
        }

        // Floyd-Warshall
        for (int mid = 1; mid <= n; mid++) {
            for (int row = 1; row <= n; row++) {
                for (int col = 1; col <= n; col++) {
                    if (row == col) continue;
                    if (adjMat[row][mid] == INF) continue;
                    if (adjMat[mid][col] == INF) continue;

                    int calc = adjMat[row][mid] + adjMat[mid][col];
                    adjMat[row][col] = Math.min(adjMat[row][col], calc);
                }
            }
        }

        ans = adjMat[s][a] + adjMat[s][b];

        for (int i = 1; i <= n; i++) {
            int amount = adjMat[s][i] + adjMat[i][a] + adjMat[i][b];
            ans = Math.min(ans, amount);
        }

        return ans;
    }
}