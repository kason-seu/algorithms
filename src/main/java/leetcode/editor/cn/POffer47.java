package leetcode.editor.cn;

public class POffer47 {


    public int maxValue(int[][] grid) {

        int[][] record = new int[grid.length][grid[0].length];
        record[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            record[i][0] = grid[i][0] + record[i-1][0];
        }
        for (int j = 1; j < grid[0].length;j ++) {
            record[0][j] = grid[0][j] + record[0][j-1];
        }

        for (int i = 1; i<=grid.length - 1; i++) {

            for (int j = 1 ; j <= grid[0].length -1;j++) {

                record[i][j] = Math.max(record[i-1][j] + grid[i][j], record[i][j-1] + grid[i][j]);
                System.out.println(" i " + i + " " + j + " msx " + record[i][j]);
            }


        }

        return record[grid.length - 1][grid[0].length - 1];
    }

}
