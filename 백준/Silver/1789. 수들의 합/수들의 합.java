import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long s = scan.nextLong();
        long result = 0;
        long i = 0;

        while (s > result) {
            i++;
            result += i;
        }

        if (result == s) {
            System.out.println(i);
        } else {
            System.out.println(i - 1);
        }
    }
}