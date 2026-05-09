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

 /**
 BFS- empty nodes
 take -1 nonempty nodes in q
 cf

 1 0
2 1
4 2
4 3
8 4
16 5
32 6
0 7
  */
class Solution {
    class Node {
        TreeNode node;
        int idx;
        Node(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }  
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root,0));
        int max = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int start = 0, end = 0;
            for(int i=0; i<size; i++){
                Node p = q.poll();
                int index = p.idx; 
                if(i==0) start = index; //start and end index for each level
                if(i==size-1) end = index;
                if(p.node.left!=null){
                    q.add(new Node(p.node.left, 2*p.idx+1));
                }
                
                if(p.node.right!=null){
                    q.add(new Node(p.node.right, 2*p.idx+2));
                }
            }
            max = Math.max(max, end - start + 1);
        }
        return max; 
    }


    //TLE
    //  public int widthOfBinaryTree(TreeNode root) {
    //     Queue<TreeNode> q=new LinkedList<>();
    //     q.add(root);
    //     int r=-1,ans=0;
    //     while(!q.isEmpty()){
    //         int s=q.size();
    //         int wf=0,w=0;
    //         boolean start=false;
    //         r++;
    //         for(int i=0;i<s;i++){
    //             TreeNode t=q.poll();

    //             if(t.val!=-1){
    //                 w++;
    //                 if(start) w+=wf;
    //                 wf=0;
    //                 start=true;
    //             }else{
    //                 wf++;
    //             }

    //             if(t.left!=null){
    //                 q.add(t.left);
    //             }else{
    //                 TreeNode emptyNode=new TreeNode(-1);
    //                 t.left=emptyNode;
    //                 q.add(emptyNode);
    //             }

    //             if(t.right!=null){
    //                 q.add(t.right);
    //             }else{
    //                 TreeNode emptyNode=new TreeNode(-1);
    //                 t.right=emptyNode;
    //                 q.add(emptyNode);
    //             }
    //             // System.out.println(t.val+" "+w);
    //         }
    //         // System.out.println(w+" "+r);
    //         if(wf==(1<<r)) break;
    //         ans=Math.max(ans, w);
    //     }
    //     return ans;
    // }
}