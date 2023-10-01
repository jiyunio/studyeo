import javax.print.DocFlavor;
import java.util.*;

class Find {
    public int find_prime(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Vector<Integer> v = new Vector<>();
        Find find = new Find();

        for (int i = 0; i < N; i++) {
            v.add(scan.nextInt());
        }

        int count = 0;
        for (int i = 0; i<v.size();i++){
            int num = v.get(i);
            count += find.find_prime(num);
        }
        System.out.println(count);
    }
}
