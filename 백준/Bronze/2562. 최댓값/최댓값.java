import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Vector<Integer> v = new Vector<>();
        int max = 0;
        int index = 0;
        for (int i = 0; i < 9; i++) {
            v.add(scan.nextInt());
        }
        for (int i = 0; i < 9; i++) {
            if (max < v.get(i)){
                max = v.get(i);
                index = i;
            }
        }
        System.out.println(max);
        System.out.println(index+1);
    }
}