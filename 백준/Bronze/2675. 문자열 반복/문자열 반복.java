import javax.swing.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int r;
        String s;
        for (int i = 0; i < t; i++) {
            r = scan.nextInt();
            s = scan.next();

            for (int j = 0; j < s.length(); j++) {
                for (int m = 0; m < r; m++) {
                    System.out.print(s.charAt(j));
                }
            }
            System.out.println();
        }


    }
}