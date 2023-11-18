import java.security.KeyStore;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n + m; i++) {
            String s = scan.next();
            if (map.containsKey(s)) {
                int a = map.get(s);
                map.put(s, a+1);
            } else {
                map.put(s, 1);
            }
        }

        Vector<String> v = new Vector<>();
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                continue;
            } else {
                v.add(key);
            }
        }
        Collections.sort(v);
        System.out.println(v.size());
        for (int i = 0; i < v.size(); i++) {
            System.out.println(v.get(i));
        }
    }
}