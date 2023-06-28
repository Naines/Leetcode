import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * MaximumProbabilityPath1514
 */
public class MaximumProbabilityPath1514 {



    public static  double maxProbability(int n, Node nodes[], int start, int end){
        double ans=0.0;
        Queue<Node> q=new LinkedList<>();
        q.add(nodes[start]);
        while(!q.isEmpty()){
            double levelMax=0.0;
            while(q.size()>0){
                Node temp = q.poll();
                List<Edge> all = temp.edges;
                for(Edge e: all){
                    double prob = Math.pow(Math.E, Math.log(ans)+Math.log(e.wt));
                    levelMax = Math.max(levelMax, prob);
                    q.add(nodes[e.b]);
                }
            }
            levelMax=ans;
        }
        return ans;

    }

    public static void main(String[] args) {
        int edges[][]={{0,1},{1,2},{0,2}};
        double prob[] = {0.5, 0.5, 0.2};
        int start=0, end=2;
        int n=2;

        Node nodes[] =new Node[n];
        for(int i=0;i<n;i++) nodes[i] = new Node(i);
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0], b= edges[i][1];
            nodes[a].edges.add(new Edge(a, b, prob[i]));
        }
        for(Node node: nodes) System.out.println(node);
        System.out.println(maxProbability(n, nodes, start, end));
    }


    static class Node{
        List<Edge> edges;
        int id;
        Node(int id){
            this.id = id;
            edges = new ArrayList<>();
        }
        public String toString(){
            return this.edges+" "+this.id;
        }
    }

    static class Edge implements Comparable<Edge>{
        int a, b;
        double wt;
        Edge(int a, int b, double wt){
            this.a=a;
            this.b=b;
            this.wt=wt;
        }
        public int compareTo(Edge o){
            return Double.compare(this.wt, o.wt);
        }
        public String toString(){
            return this.a+"--"+this.b+"==:"+this.wt;
        }
    }
}