import java.util.*;

public class Main {
    static ArrayList<Integer> a_list = new ArrayList<>();
    static ArrayList<Integer> b_list = new ArrayList<>();
    static int result = 0;

    static void sum() {
        for (int i = 0; i < a_list.size(); i++) {
            result += a_list.get(i) * b_list.get(i);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            a_list.add(scan.nextInt());
        }
        for (int i = 0; i < N; i++) {
            b_list.add(scan.nextInt());
        }
        Collections.sort(a_list);
        b_list.sort(Collections.reverseOrder());
        sum();

        System.out.println(result);
    }
}