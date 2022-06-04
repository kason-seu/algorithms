package leetcode.editor.cn;

public class POffer13 {

    public int movingCount(int m, int n, int k) {

        boolean[][] visited = new boolean[m][n];
        return recur(0,0, k, m, n, visited);
    }

    private int recur(int i, int j, int k, int m, int n, boolean[][] visited) {

        if (i % 10 + i / 10 + j % 10 + j / 10 > k) {
            return 0;
        }
        if (i > (m - 1) || j > (n - 1)) {
            return 0;
        }

        int s = 1;
        visited[i][j] = true;
        if (i + 1 < m && !visited[i+1][j]) {
            s = s + recur(i + 1, j, k, m, n, visited);
        }
        if (j + 1 < n && !visited[i][j+1]) {
            s = s + recur(i, j + 1, k, m, n, visited);

        }

        return s;
    }
}
