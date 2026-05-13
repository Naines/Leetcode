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
 /**
 CASE: [2,2,2] 
 CASE: [-2147483648,-2147483648]
  */
class Solution {
    long min = (long)Integer.MIN_VALUE-100, max=(long)Integer.MAX_VALUE+100;
    public boolean isValidBST(TreeNode root) {
        // System.out.println(min+" "+max);
        return dfs(root, min, max);
    }
    boolean dfs(TreeNode root, long min, long max){
        if(root==null) return true;
        boolean l= dfs(root.left, min ,(long)root.val-1);
        boolean r = dfs(root.right, (long)root.val+1, max);
        // System.out.println("IN AT "+root.val+" "+min+" "+max+" "+l+" "+r);
        if(root.val<min || root.val>max) return false;
        if(l==false || r==false) return false;
        return true;
    }
}