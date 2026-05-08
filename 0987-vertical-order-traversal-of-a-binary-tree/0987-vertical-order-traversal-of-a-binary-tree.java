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
    
    static class Node{
        TreeNode n;
        int  r, c;
        Node(TreeNode n, int r, int c){
            this.n=n;
            this.r=r;
            this.c=c;
        }
    }

    List<List<Integer>> ans =new ArrayList<>();
    Map<Integer, List<Integer>> map = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Node> q=new LinkedList<>();
        Map<Integer, List<Integer>> minMap=new HashMap<>();
        q.add(new Node(root, 0,0 ));
        map.put(0, new ArrayList<>());
        map.get(0).add(root.val);
        while(!q.isEmpty()){
            int s=q.size();
            // System.out.println(s);
            for(int i=0;i<s;i++){
                Node t=q.poll();
                // System.out.println(t.n.val+" polled");
                if(t.n.left!=null){
                    int nc=t.c-1;
                    int nr=t.r+1;
                    Node tt=new Node(t.n.left, nr, nc);
                    // System.out.println(tt.n.val+" "+nc);
                    q.add(tt);
                    if(!map.containsKey(nc)){
                        map.put(nc, new ArrayList<>());
                    }
                    if(!minMap.containsKey(nc)){
                        minMap.put(nc, new ArrayList<>());
                    }
                    minMap.get(nc).add(tt.n.val);
                }

                if(t.n.right!=null){
                    int nc=t.c+1;
                    int nr=t.r+1;
                    Node tt=new Node(t.n.right, nr, nc);
                    // System.out.println(tt.n.val+" "+nc);

                    q.add(tt);
                    if(!map.containsKey(nc)){
                        map.put(nc, new ArrayList<>());
                    }
                    if(!minMap.containsKey(nc)){
                        minMap.put(nc, new ArrayList<>());
                    }
                    minMap.get(nc).add(tt.n.val);
                }
                //included minMap to largeMap
            }
            for(Map.Entry<Integer, List<Integer>> e: minMap.entrySet()){
                int key=e.getKey();
                Collections.sort(e.getValue());
                map.get(key).addAll(e.getValue());
            }
            minMap.clear();
        }
        for(Map.Entry<Integer, List<Integer>> e: map.entrySet()){
           ans.add(e.getValue());
        }
        return ans;
    }
}