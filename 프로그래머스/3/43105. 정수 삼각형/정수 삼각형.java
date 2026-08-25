import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        
        for(int i = 1; i<triangle.length; i++) {
            for(int j = 0; j<triangle[i].length; j++) {
                if(triangle[i-1].length - 1 >= j) {
                    if(j-1 >= 0) {
                        triangle[i][j] = Math.max(triangle[i][j] + triangle[i-1][j-1], triangle[i][j] + triangle[i-1][j]);  
                    } else {
                        triangle[i][j] += triangle[i-1][j];
                    }
                } else {
                    triangle[i][j] += triangle[i-1][j-1];
                }
            }
        }
        
        Arrays.sort(triangle[triangle.length-1]);
        int[] t = triangle[triangle.length-1];
        return t[t.length-1];
    }
}