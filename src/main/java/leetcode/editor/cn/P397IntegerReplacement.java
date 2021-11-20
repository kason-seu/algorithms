/**
 * 题目Id：397
 * 题目：整数替换
 * 内容: //给定一个正整数 n ，你可以做如下操作：
 * //
 * //
 * // 如果 n 是偶数，则用 n / 2替换 n 。
 * // 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * //
 * //
 * // n 变为 1 所需的最小替换次数是多少？
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：n = 8
 * //输出：3
 * //解释：8 -> 4 -> 2 -> 1
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：n = 7
 * //输出：4
 * //解释：7 -> 8 -> 4 -> 2 -> 1
 * //或 7 -> 6 -> 3 -> 2 -> 1
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：n = 4
 * //输出：2
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= n <= 2³¹ - 1
 * //
 * // Related Topics 贪心 位运算 记忆化搜索 动态规划 👍 187 👎 0
 * <p>
 * 日期：2021-11-19 21:27:03
 */
//给定一个正整数 n ，你可以做如下操作： 
//
// 
// 如果 n 是偶数，则用 n / 2替换 n 。 
// 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。 
// 
//
// n 变为 1 所需的最小替换次数是多少？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 8
//输出：3
//解释：8 -> 4 -> 2 -> 1
// 
//
// 示例 2： 
//
// 
//输入：n = 7
//输出：4
//解释：7 -> 8 -> 4 -> 2 -> 1
//或 7 -> 6 -> 3 -> 2 -> 1
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// Related Topics 贪心 位运算 记忆化搜索 动态规划 👍 187 👎 0

package leetcode.editor.cn;

import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class P397IntegerReplacement {
    public static void main(String[] args) {
        Solution solution = new P397IntegerReplacement().new Solution();
        int i = solution.integerReplacement(8);
        System.out.println("Hello world" + i);
        i = solution.integerReplacement(7);
        System.out.println("Hello world" + i);
        i = solution.integerReplacement(2147483647);
        System.out.println("Hello world" + i);
        i = solution.integerReplacement(4);
        System.out.println("Hello world" + i);

        System.out.println("========================");


        i = solution.integerReplacementV2(8);
        System.out.println("Hello world" + i);
        i = solution.integerReplacementV2(7);
        System.out.println("Hello world" + i);
        i = solution.integerReplacementV2(2147483647);
        System.out.println("Hello world" + i);
        i = solution.integerReplacementV2(4);
        System.out.println("Hello world" + i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int integerReplacement(int n) {
            long num = n + 2;

            Map<Long, Integer> map = new HashMap<>();

            return integerReplacementDg(n, map);
        }
        public int integerReplacementV2(int n) {
            Map<Integer, Integer> map = new HashMap<>();
            return integerReplacementDgV2(n, map);
        }
        public int integerReplacementDg(long n, Map<Long, Integer> map) {

            if (n == 1) {
                //arr[n] = 0;
                //arr.add(n, 0);
                map.put(n, 0);
                return 0;
            }

            long yushu = n % 2;
            int sumOdd = 0;
            int sumJishu1 = 0;
            int sumJishu2 = 0;
            if (yushu == 0) {
                sumOdd += 1;
                if (map.get(n / 2) != null) {
                    sumOdd += map.get(n / 2);
                } else {
                    sumOdd += integerReplacementDg(n / 2, map);
                }

            } else {
                sumJishu1 += 1;
                if (map.get(n + 1) != null) {
                    sumJishu1 += map.get(n + 1);
                } else {
                    sumJishu1 += integerReplacementDg(n + 1, map);
                }

                sumJishu2 += 1;
                if (map.get(n - 1) != null) {
                    sumJishu2 += map.get(n - 1);
                } else {
                    sumJishu2 += integerReplacementDg(n - 1, map);
                }
            }
            int min = getMin(sumOdd, sumJishu1, sumJishu2);
            map.put(n, min);
            return min;
        }

        public int integerReplacementDgV2(int n, Map<Integer, Integer> map) {

            if (n == 1) {
                map.put(n, 0);
                return 0;
            }

            long yushu = n % 2;
            int sumOdd = 0;
            int sumJishu1 = 0;
            int sumJishu2 = 0;
            if (yushu == 0) {
                sumOdd += 1;
                if (map.get(n / 2) != null) {
                    sumOdd += map.get(n / 2);
                } else {
                    sumOdd += integerReplacementDgV2(n / 2, map);
                }
                map.put(n, sumOdd);
                return sumOdd;
            }
            sumJishu1 += 2;
            if (map.get(1 + (n-1)/2) != null) {
                sumJishu1 += map.get(1 + (n-1)/2);
            } else {
                sumJishu1 += integerReplacementDgV2(1 + (n-1)/2, map);
            }

            sumJishu2 += 2;
            if (map.get((n - 1)/2) != null) {
                sumJishu2 += map.get((n - 1)/2);
            } else {
                sumJishu2 += integerReplacementDgV2((n - 1)/2, map);
            }

            int min = Math.min(sumJishu1, sumJishu2);
            map.put(n, min);
            return min;
        }

        private int getMin(int sumOdd, int sumJishu1, int sumJishu2) {
            if (sumOdd == 0 && sumJishu1 == 0 && sumJishu2 == 0) {
                return 0;
            } else {
                sumOdd = sumOdd == 0 ? Integer.MAX_VALUE : sumOdd;
                sumJishu1 = sumJishu1 == 0 ? Integer.MAX_VALUE : sumJishu1;
                sumJishu2 = sumJishu2 == 0 ? Integer.MAX_VALUE : sumJishu2;
                int temp = Math.min(sumOdd, sumJishu1);
                return Math.min(sumJishu2, temp);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}