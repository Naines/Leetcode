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
    static int preIndex;
    Map<Integer, Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex=0;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        this.root=builder(preorder, 0, inorder.length-1);
        return root;
    }
    TreeNode builder(int pre[], int s, int e){
        if(s>e) return null;
        //System.out.println(preIndex);
        TreeNode temp=new TreeNode(pre[preIndex++]);
       
        int index=map.get(temp.val);
        temp.left=builder(pre, s, index-1);
        temp.right=builder(pre, index+1, e);
        return temp;
    }
}