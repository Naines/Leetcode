class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node nodes[]=new Node[numCourses];
        for(int i=0;i<numCourses;i++){
            nodes[i] = new Node(i);
        }
        int degree[]=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            nodes[prerequisites[i][1]].list.add(nodes[prerequisites[i][0]]);
            degree[prerequisites[i][0]]++;
        }
        int count = count(degree, nodes);
        System.out.println(nodes+" "+count);
        return count==numCourses;
    }

    int count(int degree[], Node nodes[]){
        Queue<Node> q=new ArrayDeque<>();
        int count =0;
        for(int i=0;i<degree.length;i++){
            if(degree[i]==0){
                q.add(nodes[i]);
                count++;
            }
        }
        
        while(!q.isEmpty()){
            Node x = q.poll();
            for(Node v: x.list){
                degree[v.val]--;
                if(degree[v.val]==0){
                    q.add(v);
                    count++;
                }
            }
        }
        return count;
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