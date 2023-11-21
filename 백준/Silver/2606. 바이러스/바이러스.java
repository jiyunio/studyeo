import javax.swing.plaf.IconUIResource;
import java.awt.image.ImageProducer;
import java.io.*;
import java.util.*;

class Find {
    Vector<Integer> v = new Vector<>();
    Vector<Integer> store = new Vector<>();
    int count = 0;

    public Vector<Integer> find_virus(int x, int y, int[][] all, int[] visit) {
        while (y + 1 <= visit.length) {
            if (all[x][y] == 1) {
                visit[x] = 1;
                visit[y] = 1;
                if (!store.contains(y)){
                    v.add(y); // 중복 없애기
                    store.add(y);
                }
            }
            find_virus(x, y + 1, all, visit); // 오른쪽으로 쭉 가기
            return store;
        }

        if (!v.isEmpty()) { // 비어있지 않으면
            int n = v.get(0);
            v.remove(0);
            if (n == 1) {
                if(v.isEmpty()) return store;

                n = v.get(0);
                v.remove(0);
            }
            find_virus(n, 2, all, visit); // 1부터는 맨 초반에 이미 다 체크했으니까
            return store;
        }
        return store;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int connect_n = scan.nextInt();
        int[][] all_point = new int[n + 1][n + 1];
        Find find = new Find();

        for (int i = 0; i < connect_n; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            all_point[x][y] = 1;
            all_point[y][x] = 1;
        }
        int[] visit = new int[n + 1];
        Vector<Integer> result = new Vector<>();
        all_point[1][1] = 1;
        result = find.find_virus(1, 1, all_point, visit);

        System.out.println(result.size()-1); // 1이 들어가 가있음
    }
}