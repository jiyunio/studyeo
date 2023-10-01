import java.util.*;

class Calcul {
    private double sum;
    public double change(double n, double max) {
        return n / max * 100;
    }
    public void min(Vector<Double> v){
        for (int i = 0; i<v.size(); i++){
            sum += v.get(i);
        }
        System.out.printf("%.2f", sum/v.size());
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sub_num = scan.nextInt();
        double max_score = 0;
        Calcul cal = new Calcul();
        Vector<Double> vec_score = new Vector<>();

        for (int i = 0; i < sub_num; i++) {
            vec_score.add(scan.nextDouble());
            if (max_score < vec_score.get(i)) {
                max_score = vec_score.get(i); // max_score에 최댓값 설정
            }
        }

        for (int i = 0; i<sub_num;i++){
            double mid = cal.change(vec_score.get(i), max_score);
            vec_score.set(i, mid);
        }
        cal.min(vec_score);
    }
}