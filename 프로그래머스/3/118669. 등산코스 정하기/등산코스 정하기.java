import java.util.*;

/*
다익스트라는 최단경로를 만드는 것
이것는 최소 intensity를 만드는 것

해당 경로까지 갔을 때, intensity가 최소가 되는 경로로 가면 됨
total은 신경쓰지 않아도 된다.
*/

class Edge implements Comparable<Edge> {
    int v;
    int w;
    
    Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }
    
    @Override
    public int compareTo(Edge e) {
        if(this.w == e.w) { //가중치가 같다면 노드값으로 오름차순 정렬
            return Integer.compare(this.v, e.v);
        }
        return Integer.compare(this.w, e.w); //오름차순 정렬
    }
}

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        Arrays.fill(answer, Integer.MAX_VALUE);
        
        HashSet<Integer> summit = new HashSet<>();
        for(int s : summits) {
            summit.add(s);
        }
        HashSet<Integer> gate = new HashSet<>();
        for(int g : gates) {
            gate.add(g);
        }
        
        //그래프 초기화
        ArrayList<Edge>[] graph = new ArrayList[n+1]; //1~n까지
        for(int i = 0; i<n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] p : paths) {
            int s = p[0];
            int e = p[1];
            int w = p[2];
            
            graph[s].add(new Edge(e, w));
            graph[e].add(new Edge(s, w));
        }
        
        PriorityQueue<Edge> result = new PriorityQueue<>();
        for(int g : gates) {
            //pq : 우선순위큐 (가중치에 대해 오름차순 정렬)
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.add(new Edge(g, 0));
            
            //dist : [n]까지 갔을 때의 최소 intensity (intensity : 경로 중에서 최댓값)
            int[] dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[g] = 0;
            
            while(!pq.isEmpty()) {
                Edge edge = pq.poll();
                
                if(dist[edge.v] < edge.w) continue; //더 큰 가중치 경로는 갈 필요없음
                if(summit.contains(edge.v)) {
                    result.add(edge);
                    break;
                }
                
                for(Edge e : graph[edge.v]) { //주변 정점
                    if(dist[e.v] > Math.max(edge.w, e.w) && !gate.contains(e.v)) {
                        dist[e.v] = Math.max(edge.w, e.w);
                        pq.add(new Edge(e.v, dist[e.v]));
                        //System.out.printf("edge.v : %d | e.v : %d | e.w : %d | dist[e.v] : %d\n", edge.v, e.v, e.w, dist[e.v]);
                    }
                }
            }
            
            // //각 출입구에 대해 answer 갱신
            // for(int s : summits) { 
            //     if(answer[0] == s) { //산봉우리가 같을 때
            //         answer[1] = Math.min(answer[1], dist[s]); //intensity 최솟값으로 갱신
            //     } else { //산봉우리가 다를 때
            //         if(answer[1] > dist[s]) { //intensity 최솟값 갱신이 가능할 때
            //             answer[0] = s;
            //             answer[1] = dist[s];
            //         }
            //     }
            // }
        }
        
        Edge e = result.poll();
        answer[0] = e.v;
        answer[1] = e.w;
        
        return answer;
    }
}