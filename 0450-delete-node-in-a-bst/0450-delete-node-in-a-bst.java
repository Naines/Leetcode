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
    //search in o(logn)
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null ) return null;
        if(root.val > key) root.left = deleteNode(root.left, key);
        else if(root.val < key) root.right = deleteNode(root.right, key);
        else{
            //case 0,1 children
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            TreeNode rightSmall = root.right;
            while(rightSmall.left!=null) rightSmall = rightSmall.left;
            rightSmall.left = root.left;
            return root.right; 
        } 
        return root;
    }
}