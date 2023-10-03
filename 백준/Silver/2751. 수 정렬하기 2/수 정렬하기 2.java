import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{

            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(bf.readLine());
            Vector<Integer> v = new Vector<>();

            for (int i = 0; i < n; i++ ){
                v.add(Integer.parseInt(bf.readLine()));
            }

            Collections.sort(v);

            for (int i = 0; i < n; i++ ){
                bw.write(v.get(i) + "\n");
            }
            bw.flush();
            bw.close();
    }
}