import javax.swing.text.Style;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0;

        while(n != 0) {
            if(n >= 3){
                n -= 3;
                count++;
            }else{
                n -= 1;
                count++;
            }
        }


        if (count % 2 == 1) {
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }

    }
}