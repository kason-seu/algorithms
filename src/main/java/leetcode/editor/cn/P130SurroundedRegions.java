/**
  * 题目Id：130
  * 题目：被围绕的区域
  * 内容: //给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 736 👎 0
	
  * 日期：2022-03-02 23:14:04
*/
//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 736 👎 0

package leetcode.editor.cn;
public class P130SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new P130SurroundedRegions().new Solution();
        char[][]board = new char[][]{
                {'O','O'} , {'O', 'O'}
        };
        solution.solve(board);
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solve(char[][] board) {


        // 处理第一行
        int nc = board[0].length;
        for (int i = 0 ; i < nc; i++) {
            if (board[0][i] == 'O') {
                dfs(0, i, board);
            }
        }
        for (int i = 0 ; i < nc; i++) {
            if (board[board.length - 1][i] == 'O') {
                dfs(board.length - 1, i, board);
            }
        }

        int nr = board.length;
        for (int i = 0; i < nr; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }
        }
        for (int i = 0; i < nr; i++) {
            if (board[i][nc - 1] == 'O') {
                dfs(i, nc - 1, board);
            }
        }

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (board[i][j] == 'Z') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(int row, int col, char[][]board) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == 'X' || board[row][col] == 'Z') {
            return;
        }
        if (board[row][col] == 'O') {
            board[row][col] = 'Z';
        }

        dfs(row - 1, col, board);
        dfs(row + 1, col, board);
        dfs(row  , col - 1, board);
        dfs(row , col + 1, board);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}