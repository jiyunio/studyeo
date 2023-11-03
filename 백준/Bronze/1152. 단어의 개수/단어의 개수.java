import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        StringTokenizer strToken = new StringTokenizer(str);

        int count = 0;
        while (strToken.hasMoreTokens()){
            strToken.nextToken();
            count++;
        }

        System.out.println(count);
    }
}