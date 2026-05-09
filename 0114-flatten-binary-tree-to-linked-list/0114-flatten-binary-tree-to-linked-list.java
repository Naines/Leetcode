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
    public void flatten(TreeNode root) {
        dfs(root);
    }

    //follow postorder - left, right, center
    //l, r
    //root.l = null;
    // root.right=left;
    // while(!root.right) root=root.right
    //root.right=right
    void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        dfs(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right=left;
        while(root.right!=null) root=root.right;
        root.right=right;
    }
}