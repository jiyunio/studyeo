import java.util.*;

/*
dp[i] : i까지의 누적 최댓값
스티커의 양옆은 선택하지 못함
현재 스티커를 선택한다면 옆인 i-1 인덱스가 아닌 i-2를 선택해야 함 i-2는 i-2까지의 누적합이기 때문에 어떤 값을 선택해왔든 최댓값을 보장하며 i와 더할 수 있음

*/

class Solution {
    public int solution(int sticker[]) {
        if(sticker.length == 1) {
            return sticker[0];
        }
        
        //인덱스 0부터 시작했을 때 (마지막 인덱스는 선택하지 못하니 제외)
        int[] dp0 = new int[sticker.length];
        dp0[0] = sticker[0];
        dp0[1] = Math.max(dp0[0], sticker[1]);
        for(int i = 2; i<sticker.length-1; i++) {
            dp0[i] = Math.max(dp0[i-1], dp0[i-2] + sticker[i]);
        }
        Arrays.sort(dp0);
        
        //인덱스 1부터 시작했을 때 (마지막 인덱스 선택 가능)
        int[] dp1 = new int[sticker.length];
        dp1[0] = 0;
        dp1[1] = sticker[1];
        for(int i = 2; i<sticker.length; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
        }
        Arrays.sort(dp1);
        
        return Math.max(dp0[sticker.length - 1], dp1[sticker.length - 1]);
    }
}