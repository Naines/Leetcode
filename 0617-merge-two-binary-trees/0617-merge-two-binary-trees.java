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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(new TreeNode(0),root1, root2);
    }

    TreeNode dfs(TreeNode root, TreeNode root1, TreeNode root2){
        if(root1==null && root2==null){
            return null;
        }
        if(root1==null || root2==null)
        return root1==null?root2:root1;
        root=new TreeNode(0);
        root.val=root1.val+root2.val;
        root.left = dfs(root.left, root1.left, root2.left);
        root.right = dfs(root.right, root1.right, root2.right);
        return root;

    }
}