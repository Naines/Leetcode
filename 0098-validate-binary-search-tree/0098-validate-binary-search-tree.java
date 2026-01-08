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
   TreeNode par; 
    public boolean isValidBST(TreeNode root) {
        return find(root);
    }

    boolean find(TreeNode root){
        if(root==null) return true;
        if(!find(root.left)) return false;
        if(par!=null && par.val>=root.val) return false;
        par=root;
        if(!find(root.right)) return false;
        return true;

    }
}