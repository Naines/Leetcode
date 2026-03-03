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
class Solution 
{
    boolean ans=false;
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set=new HashSet<>();
        populate(set, root);
        find(set, root,k);
        return ans;
    }
    void populate(Set<Integer> set, TreeNode root)
    {
        if(root!=null)
        {
            populate(set, root.left);
            set.add(root.val);
            populate(set, root.right);
            
        }
    }
     void find(Set<Integer> set, TreeNode root,int k)
    {
        if(root!=null)
        {
            find(set, root.left, k);
            set.remove(root.val);
            if(set.contains(k-root.val)) ans= true;
            set.add(root.val);
            find(set, root.right, k);
        }
    }
    
}