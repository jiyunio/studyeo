import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= num; i++) {
            queue.add(i);
        }

        while (queue.size() != 1){
            queue.remove(); // 첫 번째 인덱스 제거
            if (queue.size() == 1){
                break;
            }
            queue.add(queue.poll());
        }
        System.out.println(queue.peek());
    }
}