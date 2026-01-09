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
    TreeNode lca;
    int deepest = 0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        lca(root, 0);
        return lca;
    }

    private int lca(TreeNode node, int depth){
        deepest = Math.max(deepest, depth);
        if(node == null) return depth;

        int ld = lca(node.left, depth+1);
        int rd = lca(node.right, depth+1);
        if(ld == deepest && rd==deepest){
            lca = node;
        }
        return Math.max(ld, rd);
    }
}