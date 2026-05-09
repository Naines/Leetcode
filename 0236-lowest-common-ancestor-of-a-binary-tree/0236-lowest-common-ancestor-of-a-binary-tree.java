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
        if(root==p || root==q) return root; //case1: root is one of nodes
        if(l!=null && r!=null) return root; //case2: root children has p and q
        return l!=null?l:r; //case 3,4: one of child have p||q or both absent  
    }
}