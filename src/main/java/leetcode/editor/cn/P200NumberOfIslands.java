/**
  * 题目Id：200
  * 题目：岛屿数量
  * 内容: //给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1571 👎 0
	
  * 日期：2022-03-02 21:59:41
*/
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1571 👎 0

package leetcode.editor.cn;
public class P200NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int sum = 0;
        for (int i = 0 ; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    sum += dg(i, j, visited, grid);
                }
            }
        }
        return sum;

    }

    // grid【row][col] = 1 ， 看下它的上下左右是否有1
    private int dg(int row, int col, int[][] visited, char[][] grid) {

        // 上
        int up = 0;
        if (row - 1 >= 0 && visited[row-1][col] != 1 && grid[row-1][col] == '1') {
            visited[row-1][col] = 1;
            up = dg(row - 1, col, visited, grid);
        }
        int down = 0;
        if (row + 1 < grid.length && visited[row + 1][col] != 1 && grid[row+1][col] == '1') {
            visited[row + 1][col] = 1;
            down = dg(row + 1, col, visited, grid);
        }
        int left = 0;
        if (col - 1 >= 0 && visited[row][col - 1] != 1 && grid[row][col - 1] == '1') {
            visited[row][col - 1] = 1;
            left = dg(row, col - 1, visited, grid);
        }

        int right = 0;
        if (col + 1 < grid[0].length && visited[row][col + 1] != 1 && grid[row][col + 1] == '1') {
            visited[row][col + 1] = 1;
            right = dg(row, col + 1, visited, grid);
        }
        return 1;

    }

        public int numIslands2(char[][] grid) {

            int sum = 0;
            for (int i = 0 ; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1' ) {
                        sum += 1;
                        dfs(i, j, grid);
                    }
                }
            }
            return sum;

        }
    // 方法2  可以更改原始数组的值， 将1 周边岛屿临接的1全部置位0，那么深搜的次数就是岛屿的个数

        private void dfs (int row, int col, char[][] grid) {

            if (row < 0 || col < 0|| row >= grid.length || col >= grid[0].length || grid[row][col] == '0') return;
            if (grid[row][col] == '1') {
                grid[row][col] = '0';
            }
            dfs(row -1 , col, grid);
            dfs(row +1 , col, grid);
            dfs(row  , col - 1, grid);
            dfs(row  , col + 1, grid);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}