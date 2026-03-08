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
    int maxPathSum = Integer.MIN_VALUE ;
    public int maxPathSum(TreeNode root) {
       sumTree(root); 
       return maxPathSum;
    }

    int sumTree(TreeNode root){
        if(root==null) return 0;
        int leftSum = Math.max(0, sumTree(root.left));
        int rightSum = Math.max(0, sumTree(root.right));
        // List<Integer> ans = new ArrayList<>();
        // ans.add(leftSum);
        // ans.add(rightSum);
        // ans.add(leftSum+root.val);
        // ans.add(rightSum+root.val);
        // ans.add(leftSum+rightSum+root.val);
        maxPathSum = Math.max(maxPathSum, leftSum+rightSum+root.val);
        return Math.max(leftSum, rightSum) + root.val;
    }
}