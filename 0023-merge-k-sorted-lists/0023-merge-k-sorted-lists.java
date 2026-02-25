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
        if(lists==null || lists.length==0) return null; 
        int n = lists.length;
        PriorityQueue<ListNode> pq=new PriorityQueue<>(n,(a,b)->a.val-b.val );
        //add head nodes
        for(int i=0;i<n;i++){
            if(lists[i]!=null)
            pq.add(lists[i]);
        }
        ListNode head = new ListNode();
        ListNode tail = head;

        while(pq.size()>0){
            tail.next = pq.poll();
            tail = tail.next;
            if(tail.next!=null){
                pq.add(tail.next);
            }
        }
        return head.next;
    }
}