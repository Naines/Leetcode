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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return ans;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        List<Integer> l=new ArrayList<>();
        l.add(root.val);
        ans.add(l);
        int row=1;
        while(!q.isEmpty()){
            int s=q.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode t=q.poll();
                if(t.left!=null){
                    q.add(t.left);
                    list.add(t.left.val);
                }
                if(t.right!=null){
                    q.add(t.right);
                    list.add(t.right.val);
                }
            }
            if(row%2!=0){
                Collections.reverse(list);
            }
            row++;
            if(list.size()>0) ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}