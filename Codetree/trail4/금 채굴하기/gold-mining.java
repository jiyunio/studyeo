import java.util.*;
import java.io.*;

/*
손해를 보지 않고 최대한 많은 금의 개수

*/

public class Main {
    static int N;
    static int M; //금 가격
    static int[][] map;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i<N; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cost = 0;
        int max_gold = 0;
        for(int k = 0; k<2*N; ++k) {
            cost = k*k + (k+1)*(k+1);

            for(int i = 0; i<N; ++i) { //중심 위치
                for(int j = 0; j<N; ++j) {
                    int gold = 0;
                    if(map[i][j] == 1) gold = 1;

                    for(int a = 0; a<N; ++a) { //주변 탐색
                        for(int b = 0; b<N; ++b) {
                            if(a == i && b == j) continue;

                            int dist = Math.abs(i-a) + Math.abs(j-b);
                            
                            if(dist <= k) {
                                
                                if(map[a][b] == 1) ++gold;
                            }
                        }
                    }
                    
                    if(cost <= gold*M) {
                        max_gold = Math.max(max_gold, gold);
                    }
                }
            }
        }

        System.out.println(max_gold);
    }
}