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
    public ListNode addTwoNumbers(ListNode h1, ListNode h2) 
    {
        ListNode dummy=new ListNode(-1);
        ListNode newhead=dummy;
        int carry=0;
        while(h1!=null || h2!=null || carry!=0)
        {
            int sum= (h2!=null?h2.val:0) + (h1!=null? h1.val:0 )+carry;
            carry=sum/10;
            dummy.next=new ListNode(sum%10);
            dummy=dummy.next;

            h1= (h1==null)? h1: h1.next;
            h2= (h2==null)? h2: h2.next;
        }

        return newhead.next;
    }
}