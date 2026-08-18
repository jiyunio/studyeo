import java.util.*;

/*
times[0] : 소스 노드
times[1] : 타겟 노드
times[2] : 소스 -> 타켓으로 가는 시간 (가중치)

n : 노드 개수
k : 신호를 보내는 노드

k가 보내는 신호를 n개의 노드가 다 받을 때의 시간

k가 모든 노드를 최소 시간으로 다 탐색해야 함
*/

class Node{
    int id;
    int weight;

    Node(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i<times.length; i++) {
            
            int s = times[i][0];
            int e = times[i][1];
            int w = times[i][2];

            graph.get(s-1).add(new Node(e-1, w));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k-1] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> n1.weight - n2.weight);
        q.add(new Node(k-1, 0));
        
        while(!q.isEmpty()) {
            Node curNode = q.poll();
            
            if(dist[curNode.id] < curNode.weight) continue;

            for(Node nextNode : graph.get(curNode.id)) {
                if(dist[nextNode.id] > curNode.weight + nextNode.weight) {
                    dist[nextNode.id] = curNode.weight + nextNode.weight;
                    q.add(new Node(nextNode.id, dist[nextNode.id]));
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for(int d : dist) {
            if(d == Integer.MAX_VALUE) return -1;
            else {
                result = Math.max(result, d); //가장 큰 거리를 return
            }
        }
        return result;
    }
}