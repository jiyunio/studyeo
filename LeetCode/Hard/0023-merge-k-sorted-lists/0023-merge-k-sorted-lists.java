/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> q = new PriorityQueue<>(); //ListNode의 val값 정렬큐 (오름차순)
        for(ListNode node : lists) {
            while(node != null) {
                q.add(node.val);
                node = node.next;
                if(node == null) break;
            }
        }
        
        ListNode[] nodes = new ListNode[q.size()];
        for(int i = 0; i<nodes.length; i++) {
            nodes[i] = new ListNode(q.poll());
        }
        
        for(int i = 0; i<nodes.length-1; i++) { //nodes[0]에 nodes의 모든 원소를 연결
            nodes[i].next = nodes[i+1];
        }

        if(nodes.length == 0) return null;
        else return nodes[0];
    }
}