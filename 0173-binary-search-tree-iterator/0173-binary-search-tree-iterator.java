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
class BSTIterator {

    TreeNode node;
    Stack<TreeNode> stk;
    public BSTIterator(TreeNode root) {
        node = root;
        stk = new Stack<>();
    }
    
    public int next() {
        while (node != null) {
            stk.push(node);
            node = node.left;
        }
        TreeNode next = stk.pop();
        node = next.right;
        return next.val;
    }
    
    public boolean hasNext() { 
        return node!=null || !stk.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */