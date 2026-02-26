/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) 
    {
        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                return start(slow, head);
            }
        }
        return null;
    }
    ListNode start(ListNode slow, ListNode head)
    {
        while(slow!=head)
        {
            slow=slow.next;
            head=head.next;
        }
        return slow;
    }
    
}