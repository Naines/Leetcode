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
    int height(TreeNode root){
        if(root==null) return -1;
        return height(root.left)+1;
    }
    public int countNodes(TreeNode root) {
        int ans =0, h=height(root);
        while(root!=null){
            if(height(root.right)==h-1){
                ans+=(1<<h);
                root=root.right;
            }else{
                ans+=(1<<h-1);
                root=root.left;
            }
            h--;
        }
        return ans;
    }
}