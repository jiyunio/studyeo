import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static node[] graph;
    static int[] visit;
    static Queue<Integer> nextNode = new LinkedList<>();
    static int n;

    static class node {
        LinkedList<Integer> connect = new LinkedList<>();
        int parent = 0;
    }

    static void findTree() {
        while (!nextNode.isEmpty()) {
            int cur = nextNode.poll();
            visit[cur] = 1;
            for (int i : graph[cur].connect) {
                if (visit[i] != 1) {
                    graph[i].parent = cur;
                    nextNode.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new node[n + 1];
        visit = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new node();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 양방향 연결
            graph[s].connect.add(c);
            graph[c].connect.add(s);
        }
        nextNode.add(1);
        findTree();

        for (int i = 2; i < n + 1; i++) {
            System.out.println(graph[i].parent);
        }
    }
}