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
    int k; int res;
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        this.res = -1;
        inorder(root);
        return res;
    }

    void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if (--k == 0) {
            res = root.val;
            return;
        }
        inorder(root.right);
    }
}