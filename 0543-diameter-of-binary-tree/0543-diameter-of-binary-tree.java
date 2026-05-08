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
    int maxD=0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxD;
    }

    int dfs(TreeNode root){
        if(root==null) return 0;
        int l=dfs(root.left);
        int r=dfs(root.right);
        // System.out.println(l+" "+r+" "+root.val);
        maxD = Math.max(maxD,l+r);
        return Math.max(l, r)+1;
    }
}