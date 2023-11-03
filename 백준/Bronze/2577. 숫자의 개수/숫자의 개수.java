import javax.swing.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] lst = new int[10];
        long result;
        long A = scan.nextInt();
        long B = scan.nextInt();
        long C = scan.nextInt();

        result = A*B*C;
        String str = String.valueOf(result);
        int index;
        for (int i = 0; i<str.length(); i++){
            index = (str.charAt(i) - '0');
            lst[index]++;
        }

        for (int i = 0; i<10; i++){
            System.out.println(lst[i]);
        }

    }
}