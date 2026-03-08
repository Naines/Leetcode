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
    TreeNode root;
    int postIdx;
    Map<Integer, Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        postIdx = n-1;
        for(int i=0;i<n;i++){
            map.put(inorder[i], i);
        }
        this.root = build(postorder, n-1, 0);
        return root;
    }
    TreeNode build(int post[], int s, int e){
        if(postIdx<0 || s<e) return null;
        System.out.println(postIdx);
        TreeNode t= new TreeNode(post[postIdx--]);
        int idx= map.get(t.val);
        t.right = build(post, s, idx+1);
        t.left = build(post, idx-1, e);
       
        return t;
    }
}