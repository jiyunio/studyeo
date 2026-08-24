import java.util.*;

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
        //봉우리 set
        HashSet<Integer> summit = new HashSet<>();
        for(int s : summits) {
            summit.add(s);
        }
        //출입구 set
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
        
        //결과큐
        PriorityQueue<Edge> result = new PriorityQueue<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int g : gates) {
            pq.add(new Edge(g, 0));
            dist[g] = 0;
        }
        
        
        
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            
            if(dist[edge.v] < edge.w) continue; //더 큰 가중치 경로는 갈 필요없음
            if(summit.contains(edge.v)) { //봉우리 도착 | intensity가 가장 작은 경로니까 바로 break
                result.add(edge);
                continue;
            }
            
            for(Edge e : graph[edge.v]) { //주변 정점
                if(dist[e.v] > Math.max(edge.w, e.w) && !gate.contains(e.v)) {
                    dist[e.v] = Math.max(edge.w, e.w);
                    pq.add(new Edge(e.v, dist[e.v]));
                }
            }
        }
        
        
        int[] answer = new int[2];
        Edge e = result.poll();
        answer[0] = e.v;
        answer[1] = e.w;
        
        return answer;
    }
}