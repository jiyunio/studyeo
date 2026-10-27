import java.util.*;
import java.io.*;

  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        // Please write your code here.
        int answer = 0;
        for(int i = 0; i<n; ++i) {
            A: for(int j = 0; j<n; ++j) {
                int num = grid[i][j];
                
                for(int k = 1; k<m; ++k) {
                    if(j+k >= n) continue A;
                    if(grid[i][j+k] != num) continue A;
                }
                ++answer;
                break;
            }
        }


        for(int j = 0; j<n; ++j) {
            B: for(int i = 0; i<n; ++i) {
                int num = grid[i][j];

                for(int k = 1; k<m; ++k) {
                    if(i+k >= n) continue B;
                    if(grid[i+k][j] != num) continue B;
                }
                ++answer;
                break;
            }
        }

        System.out.println(answer);
    }
}