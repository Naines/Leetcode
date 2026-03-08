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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        if(root==null) return res;
        TreeNode curr = root;
        while(curr!=null || !stk.isEmpty()){
            while(curr!=null){
                stk.add(curr);
                curr=curr.left;
            }
            
            curr = stk.pop();
            //System.out.println(stk+" "+curr.val);
            res.add(curr.val);
            curr= curr.right;
        }
        return res;
    }
}