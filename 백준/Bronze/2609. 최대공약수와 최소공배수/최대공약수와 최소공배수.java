import java.util.*;

class Calcul {
    Vector<Integer> v = new Vector<>();
    public int divisor(int n1, int n2) {
        int n = (n1 < n2) ? n1 : n2;
        for (int i = 1; i <= n; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                v.add(i);
            }
        }
        return v.get(v.size() - 1); // 공약수 중 제일 큰 아이 = 최대공약수
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        Calcul cal = new Calcul();

        int divisor = cal.divisor(num1, num2);
        System.out.println(divisor);

        int a = num1 / divisor;
        int b = num2 / divisor;

        divisor = divisor * a * b;
        System.out.println(divisor);

    }
}
