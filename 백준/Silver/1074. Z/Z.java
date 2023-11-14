import java.util.Scanner;

class serch_Z {
    int result = 0;
    public int z_serch(int n, int r, int c) {
        if (n == 1) {
            return result;
        }
        else{
            int half_n = n/2;
            if (r < half_n && c < n / 2) { // 1사분면
                result = z_serch(n / 2, r, c);
            } else if (r < n / 2 && c >= n / 2) { // 2사분면
                result = result + half_n*half_n + z_serch(half_n, r, c%half_n);
            } else if (r >= n / 2 && c < n / 2) { // 3사분면
                result = result + half_n*half_n*2 + z_serch(half_n, r%half_n, c);
            } else { // 4사분면
                result  = result + half_n*half_n*3 + z_serch(half_n, r%half_n, c%half_n);
            }
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int r = scan.nextInt();
        int c = scan.nextInt();

        int n = (int)Math.pow(2, N);
        serch_Z serZ = new serch_Z();
        System.out.println(serZ.z_serch(n, r, c));

    }

}