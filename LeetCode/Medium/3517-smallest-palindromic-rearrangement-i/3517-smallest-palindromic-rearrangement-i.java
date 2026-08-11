import java.util.*;

class Solution {
    public String smallestPalindrome(String s) {
        if(s.length() < 3) return s;

        ArrayDeque<Character> deque = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for(char c : chars) {
            deque.addLast(c);
        }

        int n = s.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(deque.size() > 1) {
            char c1 = deque.pollFirst();
            char c2 = deque.peekFirst();

            if(c1 == c2) {
                deque.pollFirst(); //peek 한 것도 빼버리기
                sb.append(String.valueOf(c1));
                i += 2;
            } else {
                deque.addLast(c1);
                i++; // 다르다면 다음으로 넘기기
            }
        }
        
        if(!deque.isEmpty()) {
            sb.append(String.valueOf(deque.pollFirst()));
        }

        String str = sb.toString();
        for(int j = n/2-1; j > -1; j--) {
            sb.append(String.valueOf(str.charAt(j)));
        }

        return sb.toString();
    }
}