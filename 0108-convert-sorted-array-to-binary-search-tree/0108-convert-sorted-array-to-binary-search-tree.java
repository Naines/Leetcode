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
    public TreeNode sortedArrayToBST(int[] nums) {
        //012345
        /**
            2    3    4
            13   24   2 5
            0 4  1 5  0 3
                 0
         */

         return dfs(nums, 0, nums.length-1);
    }

    TreeNode dfs(int nums[], int l, int r){
        if(l>r) return null;
        int m=l+(r-l)/2;
        TreeNode node=new TreeNode(nums[m]);
        node.left=dfs(nums, l, m-1);
        node.right=dfs(nums, m+1, r);
        return node;
    }
}