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
        return lca(root, p, q);
    }
    TreeNode lca(TreeNode root,TreeNode p, TreeNode q){
        if(root==null) return null;
        TreeNode l=lca(root.left, p, q), r=lca(root.right,p,q);
        if(root==p || root==q) return root;
        if(l==null) return r;
        if(r==null) return l;
        return root;
    }
}