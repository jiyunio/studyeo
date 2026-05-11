import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        //participant : 참여자, completion : 완주자
        HashMap<String, Integer> hash_p = new HashMap<>();
        ArrayList<String> arr_c = new ArrayList<>();
        String answer = "";
        
        for(int i = 0; i<participant.length; i++){
            if(hash_p.containsKey(participant[i])) {
                int key = hash_p.get(participant[i]);
                hash_p.replace(participant[i], ++key);
                continue;
            }
            hash_p.put(participant[i], 1);
        }
        
        for(int i = 0; i<completion.length; i++){
            arr_c.add(completion[i]);
        }
        
        for(String s : arr_c) {
            if(hash_p.containsKey(s)) {
                hash_p.replace(s, hash_p.get(s)-1);
            }
        }
        
        for(String s : hash_p.keySet()) {
            if((int) hash_p.get(s) == 0) continue;
            answer = s;
            break;
        }
        
        return answer;
    }
}