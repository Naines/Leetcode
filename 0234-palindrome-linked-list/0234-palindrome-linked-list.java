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
    public boolean isPalindrome(ListNode head) {
        //find middle point and check using 2 pointer approach
        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }
        
        if(fast!=null && fast.next==null) slow=slow.next;
        if(slow==null) return true;
        ListNode prev = null; 
        ListNode curr=slow;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        while(prev!=null){
            if(head.val != prev.val) return false;
            head=head.next;
            prev=prev.next;
        }
        return true;
    }
}