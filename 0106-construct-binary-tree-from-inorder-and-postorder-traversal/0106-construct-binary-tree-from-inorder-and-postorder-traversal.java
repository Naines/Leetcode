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

    int p;
    Map<Integer, Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] in, int[] post) {
        int n= in.length;
        p=n-1;
        for(int i=0;i<n;i++){
            map.put(in[i], i);
        }
        return dfs(post, in, 0, n-1);
    }

    TreeNode dfs(int post[], int in[], int l, int r){
        if(l>r) return null;
        int root=post[p--];
        int iIdx = map.get(root);
        TreeNode curr=new TreeNode(in[iIdx]);
        curr.right = dfs(post, in, iIdx+1, r);
        curr.left = dfs(post, in, l, iIdx-1);
        return curr;
    }
}