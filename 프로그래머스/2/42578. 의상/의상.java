import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // key : 의상 종류, value : 의상 이름
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();
        int len = clothes.length;
        int answer = 1;

        for(int i = 0; i < len; i++) {
            String key = clothes[i][1];
            if(map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
                continue;
            }
            map.put(key, 1);
            arr.add(key);
        }

        if(arr.size() == 1) {
            return map.get(arr.get(0));
        }
        
        for(int i = 0; i<arr.size(); i++) {
            // 옷을 모두 입는 경우 + 옷을 모두 입지 않은 경우 => a + 1
            // 각 종류에 대한 경우는 독립적이기 때문에 서로 곱해줘야 함
            answer *= (map.get(arr.get(i)) + 1); 
        }

        return answer - 1; // 모든 종류의 옷을 입지 않은 경우도 계산에 포함돼있어서 1을 빼줌으로써 제외시키기
    }
}