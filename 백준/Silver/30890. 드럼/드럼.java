import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static class Node implements Comparable<Node> {
        int order;
        double num;

        Node(int o, double n) {
            order = o;
            num = n;
        }

        @Override
        public int compareTo(Node node) {
            return this.num <= node.num ? -1 : 1;
        }
    }

    public static class NodepriorityQueue extends PriorityQueue<Node> {
        @Override
        public boolean contains(Object obj) {
            if (!(obj instanceof Node)) return false;

            Node node = (Node) obj;

            for (Node n : this) {
                if (n.num == node.num) return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scanner.nextLine(), " ");
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        NodepriorityQueue queue = new NodepriorityQueue();
        for (int i = 1; i < l + 1; i++) {
            queue.add(new Node(1, (double) i / l));
        }
        for (int i = 1; i < r + 1; i++) {
            queue.add(new Node(2, (double) i / r));
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (!queue.contains(node)) System.out.print(node.order);
            else {
                System.out.print(3);
                queue.poll();
            }
        }
    }
}