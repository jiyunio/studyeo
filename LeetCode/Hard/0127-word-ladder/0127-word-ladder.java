import java.util.*;

/*
한번에 한글자만 변경할 수 있다
한글자만 달라야함

해당 글자까지 몇 번 바뀌었는지 저장
목표 글자까지 왔으면 break;



*/

class Node {
    String word;
    int count;

    Node(String word, int count) {
        this.word = word;
        this.count = count;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int size = wordList.size();
        HashSet<String> visited = new HashSet<>();

        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(beginWord, 1));
        
        while(!deque.isEmpty()) {
            Node n = deque.poll();

            if(n.word.equals(endWord)) return n.count;

            for(int i = 0; i<size; i++) {
                String w = wordList.get(i);
                if(checkWord(n.word, w) && !visited.contains(w)) { //문자열 연산 가능 체크
                    visited.add(w);
                    deque.add(new Node(w, n.count + 1));
                }
            }
        }
        return 0;
    }

    boolean checkWord(String word1, String word2) {
        //word1과 word2의 차이가 1이면 true, 아니면 false
        int count = 0;
        for(int i = 0; i<word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)) count++;
            if(count > 1) return false;
        }
        return true;
    }
}