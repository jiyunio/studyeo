import java.util.*;

/*
집 털기
인접한 두 집을 털면 경보가 울린다.
인덱스에 대한 돈이 나올 때 도둑이 훔칠 수 있는 돈의 최댓값
집 3개 이상

*/

class Solution {
    public int solution(int[] money) {
        
        //0번째 집부터 털 때 => 마지막 집을 털 수 없음
        int[] dp0 = new int[money.length];
        dp0[0] = money[0];
        dp0[1] = Math.max(dp0[0], money[1]);
        for(int i = 2; i<money.length-1; i++) {
            dp0[i] = Math.max(dp0[i-1], dp0[i-2] + money[i]);
        }
        
        //1번째 집부터 털 때 => 마지막 집 털기 가능
        int[] dp1 = new int[money.length];
        dp1[0] = 0;
        dp1[1] = money[1];
        for(int i = 2; i<money.length; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
        }
        
        return Math.max(dp0[money.length-2], dp1[money.length-1]);
    }
}