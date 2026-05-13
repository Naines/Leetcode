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

   Stack<TreeNode> stk;
   TreeNode n=null;
    public BSTIterator(TreeNode root) {
        n=root;
       stk=new Stack<>();
    }
    
    public int next() {
        while(n!=null){
            stk.push(n);
            n=n.left;
        }        
        TreeNode next=stk.pop();
        n=next.right;
        return next.val;
    }
    
    public boolean hasNext() { 
        return n!=null || !stk.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */