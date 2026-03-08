/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static class Node{
        TreeNode n;
        int i;
        Node(TreeNode n, int i){
            this.n=n;
            this.i=i;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root.right ==null && root.left==null) return 1;
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(root,0));
        int ans =1;
        while(q.size()>0){
            int s=q.size();
            int idmin = Integer.MAX_VALUE, idmax=Integer.MIN_VALUE;
            System.out.println(s);
            for(int i=0;i<s;i++){

                Node t = q.poll();
                
                if(t.n.left!=null){
                    int id = (t.i*2) +1;
                    q.add(new Node(t.n.left, id));
                    idmin=Math.min(idmin, id);
                    idmax = Math.max(idmax, id);
                }
                if(t.n.right!=null){
                     int id = (t.i*2) +2;
                    q.add(new Node(t.n.right, id ));
                    idmin=Math.min(idmin, id);
                    idmax = Math.max(idmax, id);
                }
            }
            System.out.println(idmin+" "+idmax);
            if(idmin!=Integer.MAX_VALUE || idmax!=Integer.MIN_VALUE)
            ans = Math.max(ans , idmax-idmin+1);
        }
        return ans;
    }
}