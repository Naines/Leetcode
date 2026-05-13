/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      return dfs(root, p, q);
    }

    TreeNode dfs(TreeNode r, TreeNode p, TreeNode q){
        if(r==null) return null;
        if(p.val<r.val && q.val<r.val){
            return dfs(r.left, p, q);
        }else if(p.val>r.val && q.val>r.val){
            return dfs(r.right, p, q);
        }
        return r;
    }
}