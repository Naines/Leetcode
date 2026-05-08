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
    int p=0;
    Map<Integer, Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] pre, int[] in) {
        int n= in.length;
        for(int i=0;i<n;i++){
            map.put(in[i], i);
        }
        return dfs(pre, in, 0, n-1);
    }

    TreeNode dfs(int pre[], int in[], int l, int r){
        if(l>r) return null;
        int root=pre[p++];
        int iIdx = map.get(root);
        TreeNode curr=new TreeNode(in[iIdx]);
        curr.left = dfs(pre, in, l, iIdx-1);
        curr.right = dfs(pre, in, iIdx+1, r);
        return curr;
    }
}