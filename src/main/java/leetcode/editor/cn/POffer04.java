package leetcode.editor.cn;

public class POffer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0, col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {

            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return true;
            }

        }

        return false;

    }
}
