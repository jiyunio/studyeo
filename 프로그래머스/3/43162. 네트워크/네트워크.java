import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            if(visited[i]) {
                continue;
            }
            q.offer(i);
            while(!q.isEmpty()) {
                int com = q.poll();
                visited[com] = true;
                
                for(int j = 0; j < n; j++) {
                    if(!visited[j] && computers[com][j] == 1) { //방문하지 않았고 연결돼있음
                        q.offer(j);
                    }
                }
            }
            answer++;
        }
        
        return answer;
    }
}

/*
  0 1 2 3
0 1 1
1 1 1
2     1
3


*/