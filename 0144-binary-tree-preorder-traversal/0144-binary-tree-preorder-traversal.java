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
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        // preorder(root);
        preorder1(root);
        return res;
    }


    void preorder1(TreeNode root){
        Stack<TreeNode> stk = new Stack<>();
        if(root==null) return;
        stk.add(root);
        while(!stk.isEmpty()){
            TreeNode t = stk.pop();
            res.add(t.val);
            if(t.right!=null) stk.push(t.right);
            if(t.left!=null) stk.push(t.left);
        }
    }
    // void preorder(TreeNode root){
    //     if(root==null) return;
    //     res.add(root.val);
    //     preorder(root.left);
    //     preorder(root.right);  
    // }
}