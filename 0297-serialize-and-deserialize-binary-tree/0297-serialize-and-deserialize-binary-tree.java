/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    ArrayList<Integer> result =new ArrayList<>();
    public String serialize(TreeNode root) {
       
       preorder(root);
       return result.toString();
    }
    void preorder(TreeNode root){
        if(root==null){
            result.add(null);
            return;
        }
        result.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //System.out.println(data);
        String arr[]=data.substring(1, data.length()-1).split(", ");
        Deque<String> q= new LinkedList<String>(Arrays.asList(arr));
        return dfs(q);
    }

    TreeNode dfs(Deque<String> q){
        if(q.size()==0) return null;
        String s = q.poll();
        if(s.equals("null")) return null;
        TreeNode t = new TreeNode(Integer.parseInt(s));
        t.left = dfs(q);
        t.right = dfs(q);
        return t;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));