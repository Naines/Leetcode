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
    /** MWthod 1 - Space -O(n)
    public void recoverTree(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        transverse(root, list);
        sort(list, list.size());
    }
    public void transverse(TreeNode root, List<TreeNode> list){
        if(root==null) return;
        transverse(root.left, list);
        list.add(root);
        transverse(root.right, list);
    }
    public void sort(List<TreeNode> list, int n){
        for(int i=n-1;i>0;i--){
            if(list.get(i).val<list.get(i-1).val){
                //get other unordered ele
                int j=i-1;
                while(j>=0 && list.get(j).val>list.get(i).val) j--;
                
                //replace i and j+1 as j is smaller than i
                int temp=list.get(i).val;
                list.get(i).val=list.get(j+1).val;
                list.get(j+1).val=temp;
                break;
            }
        }
    }
    */
    
    TreeNode prev=new TreeNode(Integer.MIN_VALUE), first=null,second=null;
    public void recoverTree(TreeNode root){
        transverse(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    public void transverse(TreeNode curr){
        if(curr==null) return;
        transverse(curr.left);
        
        if(first==null && prev.val>curr.val)    first=prev;
        if(first!=null && prev.val>curr.val)    second=curr;
        
        prev=curr;
        transverse(curr.right);
    }
}