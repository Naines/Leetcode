/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        int val = node.val;
        ListNode curr = node;
        ListNode nn= curr.next;
        curr.val= nn.val;
        curr.next = nn.next;
    }
}