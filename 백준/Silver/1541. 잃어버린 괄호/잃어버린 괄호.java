import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String s = br.readLine();
        String tmp = "";

        List<Integer> num = new ArrayList<>();
        List<String> oper = new ArrayList<>();

        oper.add("+"); //첫 숫자는 양수
        boolean isNagative = false;
        int idx = 0; // 첫 음수의 인덱스 저장 => 이 값 이후는 모두 -로 계산

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '+' || c == '-') {
                num.add(Integer.parseInt(tmp));
                oper.add(String.valueOf(c));

                if (c == '-' && !isNagative) {
                    idx = oper.size() - 1;
                    isNagative = true;
                }

                tmp = "";
            } else {
                tmp += String.valueOf(c);
            }
        }
        num.add(Integer.parseInt(tmp));
        int result = 0;

        if (isNagative) {
            for (int i = idx; i < num.size(); i++) {
                result -= num.get(i);
            }
            for (int i = 0; i < idx; i++) {
                result += num.get(i);
            }
        } else {
            for (int i = 0; i < num.size(); i++) {
                result += num.get(i);
            }
        }

        System.out.println(result);
    }
}