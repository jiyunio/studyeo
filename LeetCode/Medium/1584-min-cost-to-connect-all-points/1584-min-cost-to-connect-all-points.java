import java.util.*;
import java.io.*;

/*
모든 정점에 대해 가중치가 없으니까 
가중치를 모든 가중치를 구한 뒤, 그래프 MST 찾기
*/

class Node {
    int x;
    int y;
    String p;
    int dist;
    
    Node(int x, int y, String p) {
        this.x = x;
        this.y = y;
        this.p = p;
        this.dist = 0;
    }

    Node(int x, int y, String p, int dist) {
        this.x = x;
        this.y = y;
        this.p = p;
        this.dist = dist;
    }

}

class Solution {
    HashMap<String, ArrayList<Node>> graph;
    public int minCostConnectPoints(int[][] points) {
        graph = new HashMap<>();
        init(points);

        PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> Long.compare(n1.dist, n2.dist)); //가중치를 기준으로 정렬
        HashSet<String> visited = new HashSet<>();
        q.add(new Node(points[0][0], points[0][1], (points[0][0] + "," + points[0][1])));
        int result = 0;

        while(!q.isEmpty()) {
            Node node = q.poll();

            if(visited.contains(node.p)) continue;

            visited.add(node.p);
            result += node.dist;
            
            if(visited.size() == points.length) break;

            for(Node n : graph.get(node.p)) {
                if(!visited.contains(n.p)) {
                    //맨해튼 거리 계산 후 양방향 연결 (거리 == 가중치)
                    int dist = Math.abs(node.x - n.x) + Math.abs(node.y - n.y);
                    q.add(new Node(n.x, n.y, n.p, dist));
                }
            }
        }

        return result;
    }

    void init(int[][] points) {
        for(int i = 0; i<points.length; i++) {
            int s_x = points[i][0];
            int s_y = points[i][1];
            String s_p = s_x + "," + s_y;
            graph.put(s_p, graph.getOrDefault(s_p, new ArrayList<>()));

            for(int j = 0; j<points.length; j++) {
                if(i == j) continue;
                int e_x = points[j][0];
                int e_y = points[j][1];

                String e_p = e_x + "," + e_y;
                ArrayList<Node> lst1 = graph.get(s_p);
                ArrayList<Node> lst2 = graph.getOrDefault(e_p, new ArrayList<>());
                lst1.add(new Node(e_x, e_y, e_p));
                lst2.add(new Node(s_x, s_y, s_p));

                graph.put(s_p, lst1);
                graph.put(e_p, lst2);
            }
        }
    }
}