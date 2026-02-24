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
    public int sumRootToLeaf(TreeNode root) {
        if(root==null) return -1;
        return dfs(root, 0);
    }

    int dfs(TreeNode root, int n){
        if(root!=null){
            n = n*2 + root.val;
            //leaf node return n; else find sum
            if(root.left==null && root.right==null) return n;
            return dfs(root.left, n) + dfs(root.right, n);
        }else return 0;
    }
}