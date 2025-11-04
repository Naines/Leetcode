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
        //override data of next node + point curr node to next of next
        //hence deleting node and not removing node from memory
        node.val = node.next.val;
        node.next = node.next.next;
    }
}