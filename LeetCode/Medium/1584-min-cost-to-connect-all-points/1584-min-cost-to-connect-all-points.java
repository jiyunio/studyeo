import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        int[] minDist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(minDist, Integer.MAX_VALUE);

        minDist[0] = 0;

        int result = 0;

        for (int i = 0; i < n; i++) {

            // 아직 방문하지 않은 정점 중
            // MST에 연결하는 비용이 가장 작은 정점 선택
            int cur = -1;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && (cur == -1 || minDist[j] < minDist[cur])) {
                    cur = j;
                }
            }

            visited[cur] = true;
            result += minDist[cur];

            // 현재 정점과 다른 정점 사이의 거리로
            // 최소 연결 비용 갱신
            for (int next = 0; next < n; next++) {
                if (!visited[next]) {
                    int dist = Math.abs(points[cur][0] - points[next][0])
                             + Math.abs(points[cur][1] - points[next][1]);

                    minDist[next] = Math.min(minDist[next], dist);
                }
            }
        }

        return result;
    }
}