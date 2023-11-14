import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.spi.CharsetProvider;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();

        HashMap<String, String> map_key_num = new HashMap<>(); // 번호, 포켓몬 이름
        HashMap<String, String> map_key_name = new HashMap<>();

        for (int i = 0; i < m; i++) {
            String str = scan.next();
            String str_num = Integer.toString(i+1);
            map_key_num.put(str_num, str);
            map_key_name.put(str, str_num);
        }

        for (int i = 0; i < n; i++) {
            String find_poket = scan.next();
            if(map_key_name.containsKey(find_poket)){
                System.out.println(map_key_name.get(find_poket));
            }
            else{
                System.out.println(map_key_num.get(find_poket));
            }

        }
    }
}