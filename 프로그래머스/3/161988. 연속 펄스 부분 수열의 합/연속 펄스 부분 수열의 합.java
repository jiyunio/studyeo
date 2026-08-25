import java.util.*;

/*

펄스수열 : 1 또는 -1로 시작하고 번갈아 나오는 수열
펄스 수열을 각 원소끼리 곱해 연속 펄스 부분 수열을 만들기
1로 곱하기 시작하면 이후에는 -1을 곱하기
-1로 곱하면 이후에는 1을 곱하기

*/

class Solution {
    public long solution(int[] sequence) {
        long answer = Math.max(solve(sequence, 1), solve(sequence, -1));
        return answer;
    }
    
    long solve(int[] sequence, int flag) {
        long[] dp = new long[sequence.length];
        dp[0] = sequence[0] * flag;
        flag *= -1;
        
        for(int i = 1; i<dp.length; i++) {
            dp[i] = Math.max(dp[i-1] + sequence[i] * flag, sequence[i] * flag);
            flag *= -1;
        }
        Arrays.sort(dp);
        return dp[dp.length-1];
    }
}