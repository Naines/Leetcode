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
    int count =0;
    public int countNodes(TreeNode root) {
       if(root==null) return 0;
       int left = findHeightLeft(root);
       int right = findHeightRight(root);
       if(left==right) return (1<<left)-1;
       return 1 + countNodes(root.left) + countNodes(root.right);
    }
    // void dfs(TreeNode root){
    //     if(root==null) return;
    //     dfs(root.left);
    //     count++;
    //     dfs(root.right);
    // }
    public int findHeightLeft(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    public int findHeightRight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}