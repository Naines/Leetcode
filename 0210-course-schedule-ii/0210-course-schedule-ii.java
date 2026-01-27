class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Node nodes[]=new Node[numCourses];
        for(int i=0;i<numCourses;i++){
            nodes[i] = new Node(i);
        }
        int degree[]=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            nodes[prerequisites[i][1]].list.add(nodes[prerequisites[i][0]]);
            degree[prerequisites[i][0]]++;
        }
        int ans[] = order(degree, nodes);
        return ans;
    }

    int[] order(int degree[], Node nodes[]){
        Queue<Node> q=new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        int count =0;
        for(int i=0;i<degree.length;i++){
            if(degree[i]==0){
                q.add(nodes[i]);
                count++;
            }
        }
        
        while(!q.isEmpty()){
            Node x = q.poll();
            ans.add(x.val);
            for(Node v: x.list){
                degree[v.val]--;
                if(degree[v.val]==0){
                    q.add(v);
                    count++;
                }
            }
        }
        return count!=degree.length?new int[0]:ans.stream().mapToInt(Integer::intValue).toArray();
    }
    static class Node{
        int val;
        List<Node> list;
        Node(int val){
            this.val  =val;
            this.list = new ArrayList<>();
        }
    }
}