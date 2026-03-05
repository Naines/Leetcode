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
// f
// s
// 1,3,4,7,1,2
//     s        f      
// 1,3,4,7,1,2,6

//1,2
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null) return null;
        ListNode slow= head, fast=head, prev= null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow = slow.next;
            fast=fast.next.next;
        }
        //System.out.println(slow.val);
        // if(slow.next==null)return null;
        prev.next = slow.next;
        return head;
    }
}