/**
  * 题目Id：79
  * 题目：单词搜索
  * 内容: //给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 👍 1283 👎 0
	
  * 日期：2022-05-03 13:36:10
*/
//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 👍 1283 👎 0

package leetcode.editor.cn;
public class P79WordSearch {
    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
        char[][] board = new char[][] {
                {'A','B'}
        };

        String word = "BA";
        boolean exist = solution.exist(board, word);
        System.out.println("Hello world " + exist);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {

        boolean[][] visit = new boolean[board.length][board[0].length];
        if (board.length == 1 && board[0].length == 1) {
            return (board[0][0] == word.charAt(0)) && word.length() == 1 ;
        }
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                if (recur(board, i, j, visit, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }


    private boolean recur(char[][] board, int row, int col, boolean[][] visited, String word, int wordIndex) {

        if (wordIndex == word.length()) {
            return true;
        }

        boolean result = false;
        visited[row][col] = true;
        // 上下左右
        if (board[row][col] == word.charAt(wordIndex)) {
            if (row - 1 >= 0 && !visited[row-1][col]) {
                boolean f = recur(board, row - 1, col, visited, word, wordIndex + 1);
                if (f) {
                    result = f;
                    return result;
                }
            }
            if (col - 1 >= 0 && !visited[row][col - 1]) {
                if (recur(board, row , col - 1, visited, word, wordIndex + 1)) {
                    return true;
                }
            }
            if (row + 1 <= board.length - 1 && !visited[row+1][col]) {
                if (recur(board, row +1 , col, visited, word, wordIndex + 1)) {
                    return true;
                }
            }
            if (col + 1 <= board[0].length - 1 && !visited[row][col+1]) {
                if (recur(board, row  , col + 1, visited, word, wordIndex + 1)) {
                    return true;
                }
            }
            if ( wordIndex == word.length() - 1) {
                return true;
            }


        }
        visited[row][col] = false;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}