import java.util.ArrayList;
import java.util.List;

public class TimeNeededToInformAllEmployees {
    public static void main(String[] args) {

        int managers[] = { 2, 2, -1, 2, 2, 2 };
        int n = managers.length;
        int time[] = { 0, 0, 1, 0, 0, 0 };
        Node nodes[] = new Node[n + 1];
        nodes[0] = new Node(-1, 0);

        // id is true
        // id=2, time[2], managers[2],
        // but nodes[3]
        //
        for (int i = 0; i <= n; i++) {
            if (managers[i - 1] == -1) {

            } else {
                nodes[i] = new Node(i - 1, time[i - 1]);
            }
        }
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
    }
}
