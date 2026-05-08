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


 right view -> map<row, Integer>, col max value accepted for row
 */
class Solution {
    static class Node{
        TreeNode n;
        int r,c;
        Node(TreeNode n, int r, int c){
            this.n=n;
            this.c=c;
            this.r=r;
        }
    }
    List<Integer> ans = new ArrayList<>();
    Map<Integer, Integer> map=new TreeMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return ans;
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(root, 0,0));
        map.put(0, root.val);        
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                Node t=q.poll();
            
                if(t.n.left!=null){
                    int nr=t.r+1;
                    int nc=t.c-1;
                    q.add(new Node(t.n.left, nr, nc));
                    map.put(nr, t.n.left.val);
                }

                if(t.n.right!=null){
                    int nr=t.r+1;
                    int nc=t.c+1;
                    q.add(new Node(t.n.right, nr, nc));
                    map.put(nr, t.n.right.val);
                }
            }
        }
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            ans.add(e.getValue());
        }
        return ans;
    }

}