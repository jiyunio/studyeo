import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int zero_count = 0;
        ArrayList<String> lst = new ArrayList<>();
        for (int i : numbers) {
            if (i == 0) zero_count++;
            lst.add(Integer.toString(i));
        }
        
        if(zero_count == numbers.length) return "0";

        //a를 b의 앞에 둘지, 뒤에 둘지 결정
        // b+a > 0 : a가 뒤로
        Collections.sort(lst, (a, b) -> (b + a).compareTo(a + b));
        
        StringBuilder sb = new StringBuilder();
        for(String s : lst) {
            sb.append(s);
        }
        return sb.toString();
    }
}