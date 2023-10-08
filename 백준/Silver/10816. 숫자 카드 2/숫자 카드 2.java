import java.io.*;
import java.util.*;
import java.lang.*;

class Card {
    public void check_card(HashMap<Long, Long> n_map, Vector<Long> m) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m.size(); i++) {
            if (n_map.containsKey(m.get(i))) { // m의 값을 가지고 있다면
                bw.write(n_map.get(m.get(i)) + " ");
            } else {
                bw.write("0 ");
            }
        }
        bw.flush();
        bw.close();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Long, Long> n_map = new HashMap<>();
        Vector<Long> m_vec = new Vector<>();
        Card card = new Card();

        int N = Integer.parseInt(bf.readLine());
        String n = bf.readLine();
        StringTokenizer st_n = new StringTokenizer(n);

        while (st_n.hasMoreTokens()) {
            Long key = Long.parseLong(st_n.nextToken());
            if (!n_map.containsKey(key)) { // 없으면 추가하기
                n_map.put(key, 1L);
            } else { // 존재하면 증가
                long value = n_map.get(key) + 1;
                n_map.replace(key, value);
            }
        }
        int M = Integer.parseInt(bf.readLine());
        String m = bf.readLine();
        StringTokenizer st_m = new StringTokenizer(m);
        while (st_m.hasMoreTokens()) {
            m_vec.add(Long.parseLong(st_m.nextToken()));
        }

        card.check_card(n_map, m_vec);

    }
}