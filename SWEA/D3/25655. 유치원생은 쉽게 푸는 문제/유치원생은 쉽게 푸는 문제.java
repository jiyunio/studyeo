import java.io.*;
import java.util.*;
 
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 1) {
                System.out.println("0");
            } else {
                if (n % 2 == 0) {
                    int a = n / 2;
                    for (int i = 0; i<a; i++) {
                        System.out.print("8");
                    }
                    System.out.println();
                } else {
                    int a = n / 2;
                    System.out.print("4");
                    for (int i = 0; i<a; i++) {
                        System.out.print("8");
                    }
                    System.out.println();
                }
            }
        }
    }
}