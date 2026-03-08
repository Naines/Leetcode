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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> a=new ArrayList<>();
        a.add(root.val);
        res.add(a);
        while(q.size()>0){
            int s=q.size();
            a=new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode t = q.poll();
                if(t.left!=null){
                    a.add(t.left.val);
                    q.add(t.left);
                }
                if(t.right!=null) {
                    a.add(t.right.val);
                    q.add(t.right);
                }
            }
            if(a.size()>0) res.add(a);
        }
        return res;
        
    }
}