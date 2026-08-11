import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : nums) {
            q.add(n);
        }

        int result = 0;
        while(k != 0 && !q.isEmpty()) {
            result = q.poll();
            k--;
        }

        return result;
    }
}