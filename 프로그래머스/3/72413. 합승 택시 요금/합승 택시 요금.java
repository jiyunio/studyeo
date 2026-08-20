import java.util.*;

/*
최소 택시요금 구하기
합승하고 내린 뒤 따로 가기
처음부터 따로 가기
합승 유무

다익스트라
시작위치에서 목적지까지 최단 경로를 구하는 알고리즘

S에서 A와 B에 모두 가야 함 / 목적지가 두 개

택시 내리는 것에서 다익스트라
A의 다익스트라 + B의 다익스트라

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
        return this.w - e.w;
    }
}

class Solution {
    ArrayList<Edge>[] graph;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        init(n, fares);
        
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i<n+1; i++) {
            int taxi_cost = dijkstra(s, i, n);
            int a_cost = dijkstra(i, a, n);
            int b_cost = dijkstra(i, b, n);
            
            answer = Math.min(answer, (taxi_cost + a_cost + b_cost));
        }
        
        return answer;
    }
    
    void init(int n, int[][] fares) { //그래프 초기화 함수
        graph = new ArrayList[n+1];
        
        for(int i = 0; i<n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<fares.length; i++) {
            int s = fares[i][0];
            int e = fares[i][1];
            int w = fares[i][2];
            
            graph[s].add(new Edge(e, w));
            graph[e].add(new Edge(s, w));
        }
    }
    
    int dijkstra(int start, int end, int n) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            
            if(edge.v == end) break;
            if(dist[edge.v] < edge.w) continue;
            
            for(Edge e : graph[edge.v]) {
                if(dist[e.v] > edge.w + e.w) {
                    dist[e.v] = edge.w + e.w;
                    pq.add(new Edge(e.v, dist[e.v]));
                }
            }
        }
        
        return dist[end];
    }
}