import java.util.*;

class Solution {
    public int solution(int[] citations) {
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i : citations) {
            lst.add(i);
        }
        Collections.sort(lst);
        int len = lst.size(); // == 논문 개수
        
        int result = 0;
        for(int i = 0; i < len; i++) {
            int n = lst.get(i);
            if(n == 0) continue;
            for(int j = 1; j <= n; j++) { // 논문이 j개 이상인지 체크하기
                if(j <= (len - i) && j >= (i + 1)){
                    result = Math.max(result, j);
                }
            }
        }
        return result;
    }
}