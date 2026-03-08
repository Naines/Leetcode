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
    Map<TreeNode , Integer> map =new HashMap<>();
    public boolean isBalanced(TreeNode root) {
        return dfs(root); 
    }

    boolean dfs(TreeNode root){
        if(root==null) return true;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)<=1 && dfs(root.left) && dfs(root.right)) return true;
        return false;
    }

    int height(TreeNode root){
        if(root==null) return 0;
        if(map.get(root)!=null) return map.get(root);
        map.put(root, Math.max(height(root.left), height(root.right))+1);
        return map.get(root);
    }
}