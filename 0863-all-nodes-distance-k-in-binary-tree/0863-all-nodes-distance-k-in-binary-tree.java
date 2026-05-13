/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                if (top.left != null) {
                    parent.put(top.left.val, top);
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    parent.put(top.right.val, top);
                    queue.offer(top.right);
                }
            }
        }

        Set<Integer> vis = new HashSet<>();
        Queue<TreeNode> q= new LinkedList<>();
        q.add(target);
        while (k > 0 && !q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                vis.add(t.val);
                if (t.left != null && !vis.contains(t.left.val)) {
                    q.add(t.left);
                }
                if (t.right != null && !vis.contains(t.right.val)) {
                    q.add(t.right);
                }
                if (parent.containsKey(t.val) && !vis.contains(parent.get(t.val).val)) {
                    q.add(parent.get(t.val));
                }
            }
            k--;
        }
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
    }
}