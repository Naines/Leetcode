/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head){

        //original, copied
       Map<Node, Node> map=new HashMap<>();
       Node curr=head;
        while(curr!=null){
            Node newnode=new Node(curr.val);
            map.put(curr, newnode);
            curr=curr.next;
        }
        
        curr=head;
        while(curr!=null){
            map.get(curr).next=map.get(curr.next);
            map.get(curr).random=map.get(curr.random);
            curr=curr.next;
        }
        return map.get(head);
    }
}