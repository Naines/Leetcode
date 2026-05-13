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
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k);
    }

    boolean dfs(TreeNode r, int t){
        if(r==null) return false;
        if(dfs(r.left, t)) return true;
        if(set.contains(t-r.val)) return true;
        set.add(r.val);
        if(dfs(r.right, t)) return true;
        return false;
    }

}