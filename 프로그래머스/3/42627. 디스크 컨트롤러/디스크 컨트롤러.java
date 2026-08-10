import java.util.*;

class Node implements Comparable<Node> {
    int idx; //작업번호
    int reqT; //요청시간
    int proT; //작업시간
    
    Node(int idx, int reqT, int proT) {
        this.idx = idx;
        this.reqT = reqT;
        this.proT = proT;
    }
        
    @Override
    public int compareTo(Node n) {
        return this.reqT - n.reqT; //먼저 요청한 순서대로 정렬
    }
}

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Node> q = new PriorityQueue<>(); //작업큐
        for(int i = 0; i<jobs.length; i++) {
            q.add(new Node(i, jobs[i][0], jobs[i][1]));
        }
        
        PriorityQueue<Node> readyQ = new PriorityQueue<>((q1, q2) -> { //대기큐 (우선순위대로 정렬되도록 Comparator 설정)
            if(q1.proT != q2.proT) {
                return q1.proT - q2.proT;
            } 
            else if(q1.reqT != q2.reqT) {
                return q1.reqT - q2.reqT;
            } 
            return q1.idx - q2.idx;
        });
        
        int sum = 0; //반환시간 (모든 작업 종료 시각 - 모든 요청 시각)
        int time = 0; //현재시간 : 처음 작업이 시작되는 시간부터 시간이 흘러감
        while(!q.isEmpty() || !readyQ.isEmpty()) {
            while(!q.isEmpty() && q.peek().reqT <= time) { //현재 시간에 가능한 작업을 모두 대기큐에 추가
                readyQ.add(q.poll()); 
            }
            
            if(readyQ.size() > 0) { //대기큐에 작업물이 있다면
                Node n = readyQ.poll();
                sum += time + n.proT; // 작업종료시각 더하기
                sum -= n.reqT; //요청시각 빼기
                time += n.proT; //작업 처리시간만큼 시간 늘리기
            } else { //대기큐에 작업물이 없다면 시간++
                time++;
            }
        }
        
        return sum / jobs.length; //평균 출력
    }
}