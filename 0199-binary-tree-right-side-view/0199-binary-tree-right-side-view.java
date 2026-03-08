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
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        while(!q.isEmpty() && root != null) {
            result.add(q.peek().val);
            for(int i = q.size(); i > 0; i--) {
                root = q.poll();
                if(root.right != null)
                    q.add(root.right);
                if(root.left != null)
                    q.add(root.left);
            }
        }
        
        return result;
    }
}