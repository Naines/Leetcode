import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TimeNeededToInformAllEmployees {
    public static void main(String[] args) {

        int managers[] = { 5,9,6,10,-1,8,9,1,9,3,4 };
        int n = managers.length;
        int time[] = { 0,213,0,253,686,170,975,0,261,309,337 };
        Node nodes[] = new Node[n + 1];
        nodes[0] = new Node(-1, 0);
        for(int i=1;i<=n;i++){
            nodes[i] = new Node(i-1, time[i-1]);
        }
        for(int i=1;i<=n;i++){
            nodes[managers[i-1]+1].addNode(nodes[i]);
        }

        int ans=0;
        Queue<Node> q=new LinkedList<>();
        q.add(nodes[0]);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node temp= q.poll();
                for(Node child: temp.children){
                    if(child.time == 0){
                        ans = Math.max(ans, temp.time);
                    }else{
                        child.time = child.time + temp.time;
                        q.add(child);
                    }
                }   
            }
            // for(Node node: q) System.out.println(node.id);
        }
        
        System.out.println(ans);
        // System.out.println("--------------------------------------");
        // for(Node node : nodes) System.out.println(node);
        
    }

    static class Node {

        int id;
        int time;
        List<Node> children;

        public Node(int id, int time) {
            this.id = id;
            this.time = time;
            children = new ArrayList<>();
        }

        public void addNode(Node n) {
            this.children.add(n);
        }

        public String toString(){
            String kids="";
            for(Node n : this.children) kids+=n.id+" ";
            return this.id+" ("+this.time+") "+kids;
        }
    }
}
