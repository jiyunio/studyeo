import java.util.*;

class Solution {
    public int missingInteger(int[] nums) {
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i = 0; i<nums.length; i++) {
            lst.add(nums[i]);
        }
        
        int sum = lst.get(0);
        System.out.println(sum);
        for(int i = 1; i<lst.size(); i++) {
            if(lst.get(i) == lst.get(i-1) + 1) {
                sum += lst.get(i);
            } else {
                break;
            }
        }

        while(lst.contains(sum)) {
            sum++;
        }
        return sum;
    }
}