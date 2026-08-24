import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people); //오름차순 정렬
        //투포인터 초기화
        int left = 0;
        int right = people.length-1;
        
        //상태 변수 초기화
        int boat = 0; //구명보트 개수
        int sum = 0; //구명보트 누적합
        
        while(left < right) {
            sum = people[left] + people[right];
            
            if(sum > limit) {
                boat++;
                right--;
            } else {
                boat++;
                left++;
                right--;
            }
        }
        
        if(left == right) return boat + 1; //사람수가 홀수일 때
        else return boat;
    }
}