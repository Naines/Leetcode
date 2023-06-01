import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    static int dirs[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { -1, -1 }, { 1, -1 },
            { -1, 1 } };

    static int ShortestPathBinaryMatrix(int mat[][]) {
        int m = mat.length, n = mat[0].length;
        if (mat[0][0] == 1 || mat[m - 1][n - 1] == 1)
            return -1;

        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        boolean vis[][] = new boolean[m][n];

        q.add(new Pair(0, 0));
        vis[0][0] = true;
        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                if (curr.x == m - 1 && curr.y == n - 1)
                    return ans + 1;
                for (int dir = 0; dir < 8; dir++) {
                    int xx = curr.x + dirs[dir][0];
                    int yy = curr.y + dirs[dir][1];
                    if (isValid(vis, mat, xx, yy, m, n)) {
                        q.add(new Pair(xx, yy));
                        vis[xx][yy] = true;
                    }
                }
            }
            ans++;// add 1 step
        }

        return -1;
    }

    // not be vis, mat[x][y]!=1 and should not be out of grid i.e x,y>=0 && x<m &&
    // y<n
    static boolean isValid(boolean vis[][], int mat[][], int xx, int yy, int m, int n) {
        return xx >= 0
                && yy >= 0
                && xx < m
                && yy < n
                && !vis[xx][yy]
                && mat[xx][yy] != 1;
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int mat[][] = new int[][] { { 0, 1 }, { 1, 0 } };
        System.out.println(ShortestPathBinaryMatrix(mat));
    }
}
