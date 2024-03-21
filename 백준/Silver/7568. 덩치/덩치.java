import java.util.Scanner;

public class Main {
    static person[] Doungchi;

    static class person {
        int weight;
        int height;
    }

    static int comparePerson(int n) {
        int count = 1; // 자기 자신 count 해주기
        for (int i = 0; i < Doungchi.length; i++) {
            if (i != n) {
                if (Doungchi[i].weight > Doungchi[n].weight && Doungchi[i].height > Doungchi[n].height) { // 덩치가 비교군 보다 큰 애가 있다면
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Doungchi = new person[scan.nextInt()];
        for (int i = 0; i < Doungchi.length; i++) {
            Doungchi[i] = new person();
            Doungchi[i].weight = scan.nextInt();
            Doungchi[i].height = scan.nextInt();
        }

        for (int i = 0; i < Doungchi.length; i++) {
            System.out.print(comparePerson(i) + " ");
        }
    }
}