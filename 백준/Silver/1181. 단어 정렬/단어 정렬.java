import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Vector<String> v = new Vector<>();
        String s1, s2;
        for (int i = 0; i < n; i++) {
            v.add(scan.next());
        }
        Set<String> set = new HashSet<String>(v);
        v = new Vector<>(set);
        Collections.sort(v, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()){
                    return 1; // 자리바꿈
                }
                else if (o1.length() < o2.length()){
                    return -1;
                }
                else {
                    if (o1.compareTo(o2) > 0){
                        return 1;
                    }
                    else{
                        return -1;
                    }
                }
            }
        });

        for (int i = 0; i < v.size(); i++) {
            System.out.println(v.get(i));
        }
    }
}
