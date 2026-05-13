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
    int index =0 ;
    public TreeNode bstFromPreorder(int[] preorder) {  
        return build(preorder, Integer.MAX_VALUE);
    }

    //pre : 300,9,8,1,400
    //pass parent val to function, if val exceeds, stop
    TreeNode build(int pre[], int ub){

        if(index==pre.length || pre[index]>ub)
            return null;

        TreeNode root = new TreeNode(pre[index++]);
        root.left = build(pre, root.val);
        root.right = build(pre, ub);
        return root;
    }
}