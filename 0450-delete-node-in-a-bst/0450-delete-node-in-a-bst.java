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
    public TreeNode deleteNode(TreeNode root, int key) {
        return dfs(root, key);
    }
    TreeNode dfs(TreeNode r, int k){
        if(r==null) return null;
        if(r.val>k) r.left = dfs(r.left, k);
        else if(r.val<k) r.right= dfs(r.right, k);
        else{
            //0,1 children
            if(r.left==null) return r.right;
            if(r.right==null) return r.left;

            TreeNode pre = r.left;
            while(pre.right!=null) pre=pre.right;
            pre.right = r.right;
            return r.left;
        }
        return r;
    }
}