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

    // goal is to reach last node of last row
    public int countNodes(TreeNode root) {
        int ans =0, h=height(root);
        while(root!=null){
            if(height(root.right)==h-1){
                ans+=(1<<h); //nodes in left ST
                root=root.right;
            }else{
                ans+=(1<<h-1); //nodes in right ST
                root=root.left;
            }
            h--;
        }
        return ans;
    }
}