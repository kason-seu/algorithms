/**
  * 题目Id：780
  * 题目：到达终点
  * 内容: //给定四个整数 sx , sy ，tx 和 ty，如果通过一系列的转换可以从起点 (sx, sy) 到达终点 (tx, ty)，则返回 true，否则返回 
//false。 
//
// 从点 (x, y) 可以转换到 (x, x+y) 或者 (x+y, y)。 
//
// 
//
// 示例 1: 
//
// 
//输入: sx = 1, sy = 1, tx = 3, ty = 5
//输出: true
//解释:
//可以通过以下一系列转换从起点转换到终点：
//(1, 1) -> (1, 2)
//(1, 2) -> (3, 2)
//(3, 2) -> (3, 5)
// 
//
// 示例 2: 
//
// 
//输入: sx = 1, sy = 1, tx = 2, ty = 2 
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: sx = 1, sy = 1, tx = 1, ty = 1 
//输出: true
// 
//
// 
//
// 提示: 
//
// 
// 1 <= sx, sy, tx, ty <= 10⁹ 
// 
// Related Topics 数学 👍 183 👎 0
	
  * 日期：2022-04-09 15:03:37
*/
//给定四个整数 sx , sy ，tx 和 ty，如果通过一系列的转换可以从起点 (sx, sy) 到达终点 (tx, ty)，则返回 true，否则返回 
//false。 
//
// 从点 (x, y) 可以转换到 (x, x+y) 或者 (x+y, y)。 
//
// 
//
// 示例 1: 
//
// 
//输入: sx = 1, sy = 1, tx = 3, ty = 5
//输出: true
//解释:
//可以通过以下一系列转换从起点转换到终点：
//(1, 1) -> (1, 2)
//(1, 2) -> (3, 2)
//(3, 2) -> (3, 5)
// 
//
// 示例 2: 
//
// 
//输入: sx = 1, sy = 1, tx = 2, ty = 2 
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: sx = 1, sy = 1, tx = 1, ty = 1 
//输出: true
// 
//
// 
//
// 提示: 
//
// 
// 1 <= sx, sy, tx, ty <= 10⁹ 
// 
// Related Topics 数学 👍 183 👎 0

package leetcode.editor.cn;
public class P780ReachingPoints {
    public static void main(String[] args) {
        Solution solution = new P780ReachingPoints().new Solution();




        System.out.println("Hello world " + solution.reachingPoints2(1,1,3,5));
        System.out.println("Hello world " + solution.reachingPoints2(1,1,2,2));
        System.out.println("Hello world " + solution.reachingPoints2(1,1,1,1));
        System.out.println("Hello world " + solution.reachingPoints2(35
                ,13
                ,455955547
                ,420098884));

        System.out.println("Hello world " + solution.reachingPoints2(2,4,15,9));
        System.out.println("Hello world " + solution.reachingPoints2(9,10,9,19));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {

        int[][] arr = new int[tx-sx + 1][ty-sy + 1];
        //return recursion(sx,sy,tx,ty);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = -1;
            }
        }

        return recursion(sx,sy, sx,sy,tx,ty,arr);
    }
        public boolean reachingPoints2(int sx, int sy, int tx, int ty) {

            while (tx > sx && ty > sy && tx != ty) {
                if (tx > ty) {
                    tx %= ty;
                } else {
                    ty %= tx;
                }
            }
            if (tx == sx && ty == sy) {
                return true;
            } else if (tx == sx) {
                return ty > sy && (ty - sy) % tx == 0;
            } else if (ty == sy) {
                return tx > sx && (tx - sx) % ty == 0;
            } else {
                return false;
            }

        }

    private boolean recursion(int x, int y, int tx, int ty) {

        if (x > tx) {
            return false;
        }
        if (y > ty) {
            return false;
        }
        if (x == tx && y == ty)  {
            return true;
        }
        boolean recursionX = recursion(x + y, y, tx, ty);
        if (recursionX) {
            return true;
        }
        return recursion(x, x + y, tx, ty);
    }

        private boolean recursion(int startX, int startY, int x, int y, int tx, int ty, int[][] arr) {

            if (x == tx && y == ty)  {
                arr[x - startX][y-startY] = 1;
                return true;
            }

            if (x + y <= tx ) {
                if (arr[x + y - startX][y-startY] != -1) {
                    int recursionX = arr[x + y - startX][y-startY];
                    if (recursionX == 1) {
                        return true;
                    }
                } else {
                    boolean recursionX = recursion(startX, startY,x + y, y, tx, ty,arr);
                    arr[x + y - startX][y-startY] = recursionX?1 : 0;
                    if (recursionX) {
                        return true;
                    }
                }
            }

            if (x + y <= ty ) {
                if (arr[x-startX][x+y - startY] != -1) {
                    int recursionY = arr[x-startX][x+y - startY];
                    if (recursionY == 1) {
                        return true;
                    }
                } else {
                    boolean recursionY = recursion(startX, startY,x , x + y, tx, ty,arr);
                    arr[x-startX][x + y - startY] = recursionY?1 : 0;
                    if (recursionY) {
                        return true;
                    }
                }
            }

            return false;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}