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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode behind = head, ahead=head;
        for(int i=0;i<n;i++){
            ahead = ahead.next;
        }
        if(ahead==null){
            //remove begining node
            head = head.next;
            return head;
        }
        while(ahead.next!=null){
            behind = behind.next;
            ahead=ahead.next;
        }
        //System.out.println(behind.next.val);
        behind.next = behind.next.next;
        return head;
    }
}