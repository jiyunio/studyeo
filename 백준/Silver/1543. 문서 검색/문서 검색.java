import java.util.Scanner;

public class Main {
    static String str;
    static String target;
    static int result = 0;

    static void compareString() {
        int i = 0;
        while (i < str.length()) {
            if (i + target.length() <= str.length() && target.equals(str.substring(i, i + target.length()))) {
                result++;
                str = str.substring(i + target.length()); // str 자르기
                i = 0; // str을 새로 설정했으니 비교 인덱스 시작값 초기화
                continue; // i 증가 없이 바로 넘어가기
            }
            i++; // if문 안 걸리면 i 증가
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        str = scan.nextLine();
        target = scan.nextLine();

        compareString();
        System.out.println(result);
    }
}