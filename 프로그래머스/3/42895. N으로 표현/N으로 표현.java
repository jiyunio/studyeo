import java.util.*;

class Solution {
    public int solution(int N, int number) {
        HashSet<Integer>[] lst = new HashSet[9];
        
        for(int i = 1; i < lst.length; i++) {
            // if(i == 8) return -1;
            lst[i] = new HashSet<>();
            lst[i].add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            for(int j = 1; j < i; j++) {
                for(int a : lst[j]) {
                    for(int b : lst[i - j]) {
                        lst[i].add(a + b);
                        lst[i].add(a - b);
                        lst[i].add(a * b);
                        if(b != 0) lst[i].add(a / b);
                    }
                }
            }
            
            if(lst[i].contains(number)) return i;
        }
        return -1;
    }
}


/*
1: 5
2: 5+5 5-5 5*5 5/5 55
3: 5+5+5 5-5-5 5*5*5 5/5/5 555 55+5 55-5 55*5 55/5
4: (5+5+5)*5, (5+5)*(5+5) => 3과 1 / 2와 2
5: 4와 1, 3과 2
6: 5와 1, 4와 2, 3과 3

i = 2 => 1 1
i = 3 => 1 2 2 1
i = 4 => 1 3 2 2 3 1
i = 5 => 1 4 2 3 3 2

i = 3  3
j = 1  2

lst[j]
lst[i-j]
lst[1]
lst[2]

lst[2]
lst[1]
*/