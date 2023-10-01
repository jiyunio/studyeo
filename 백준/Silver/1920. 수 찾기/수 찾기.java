import java.util.*;

class Search {
    public boolean binary_search(Vector<Integer> V1, int target, int start, int end) { // V1 = A, target = change
        if (start > end) {
            return false;
        }
        int mid = (start + end) / 2;
        if (V1.get(mid) == target) {
            return true;
        } else if (V1.get(mid) > target) {
            return binary_search(V1, target, start, mid - 1);
        } else {
            return binary_search(V1, target, mid + 1, end);
        }

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Search serch = new Search();

        int N = scan.nextInt();
        Vector<Integer> A = new Vector<>();
        for (int i = 0; i < N; i++) {
            A.add(scan.nextInt());
        }
        Collections.sort(A);

        int M = scan.nextInt();
        Vector<Integer> check = new Vector<>();
        for (int i = 0; i < M; i++) {
            check.add(scan.nextInt());
        }

        for (int i = 0; i < M; i++) {
            int target = check.get(i);
            if (serch.binary_search(A, target, 0, A.size()-1)){
                System.out.println("1");
            }
            else{
                System.out.println("0");
            }
        }

    }
}