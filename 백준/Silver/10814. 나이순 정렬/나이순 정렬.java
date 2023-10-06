import java.util.*;
import java.io.*;

class Member {
    int age;
    String[] str = new String[201]; // 나이 = 인덱스

    public void set(String name, int age) { // n : 입력개수
        this.age = age;
        if (str[this.age] == null){ // 값이 없다면
            str[this.age] = name + " ";
        }
        else{
            str[this.age] += name + " ";
        }
    }

    public void print_member() {
        for (int i = 1; i < str.length; i++) {
            if (str[i] != null) { // 값이 존재한다면
                StringTokenizer st = new StringTokenizer(str[i]);

                while (st.hasMoreTokens()) {
                    System.out.println(i + " " + st.nextToken());
                }
            }
            else{
                continue;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Member mem = new Member();

        String[] str = new String[10];
        for (int i = 0; i < N; i++) {
            String member = bf.readLine();
            StringTokenizer st = new StringTokenizer(member);
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            mem.set(name, age);
        }

        mem.print_member();
    }
}