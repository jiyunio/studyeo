import jdk.jshell.Snippet;

import java.io.*;
import java.util.Scanner;

class Main {
    static String[] lst = new String[600000];

    public static void divicon(int s, int l) { // s : 시작 인덱스, l : 분학정복범위
        if (l == 1) {
            lst[s] = "-";
        } else {
            l /= 3;
            divicon(s, l);
            divicon(s + l * 2, l);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";
        while ((input = br.readLine()) != null) {
            int n = (int)Math.pow(3, Integer.parseInt(input)); // 전체 개수
            divicon(0, n);
            for (int i = 0; i < n; i++) {
                if (lst[i] == "-") bw.write(lst[i]);
                else {
                    bw.write(" ");
                }
            }
            bw.write("\n");
            bw.flush();
        }
    }
}