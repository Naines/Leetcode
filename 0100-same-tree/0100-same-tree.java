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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //do inorder transversal and keep checking, in case diff found return false
        return dfs(p,q);
    }

    boolean dfs(TreeNode p, TreeNode q){

        //if leaf node for both
        if(p==null && q==null) return true;

         // If only one tree is null or 
         //the values are different, they are not identical
        if(p==null || q==null ||p.val!=q.val) return false;
        return dfs(p.left, q.left) && dfs(p.right, q.right);
    }
}