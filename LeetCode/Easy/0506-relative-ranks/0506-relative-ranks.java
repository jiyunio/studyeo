import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        //int[0] : 점수 | int[1] : 해당 점수의 인덱스
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int s : score) {
            q.add(s);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 1;
        while(!q.isEmpty()) {
            map.put(q.poll(), i++);
        }
        
        ArrayList<String> lst = new ArrayList<>();
        for(int s : score) {
            if(map.get(s) == 1) {
                lst.add("Gold Medal");
            }
            else if(map.get(s) == 2) {
                lst.add("Silver Medal");
            }
            else if(map.get(s) == 3) {
                lst.add("Bronze Medal");
            } else {
                lst.add(String.valueOf(map.get(s)));
            }
        }

        String[] result = new String[lst.size()];
        for(i = 0; i<result.length; i++) {
            result[i] = lst.get(i);
        }

        return result;
    }
}