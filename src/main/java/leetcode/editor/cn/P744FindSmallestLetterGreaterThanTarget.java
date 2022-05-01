/**
  * 题目Id：744
  * 题目：寻找比目标字母大的最小字母
  * 内容: //给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。 
//
// 在比较时，字母是依序循环出现的。举个例子： 
//
// 
// 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a' 
// 
//
// 
//
// 示例 1： 
//
// 
//输入: letters = ["c", "f", "j"]，target = "a"
//输出: "c"
// 
//
// 示例 2: 
//
// 
//输入: letters = ["c","f","j"], target = "c"
//输出: "f"
// 
//
// 示例 3: 
//
// 
//输入: letters = ["c","f","j"], target = "d"
//输出: "f"
// 
//
// 
//
// 提示： 
//
// 
// 2 <= letters.length <= 10⁴ 
// letters[i] 是一个小写字母 
// letters 按非递减顺序排序 
// letters 最少包含两个不同的字母 
// target 是一个小写字母 
// 
// Related Topics 数组 二分查找 👍 219 👎 0
	
  * 日期：2022-04-23 19:10:26
*/
//给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。 
//
// 在比较时，字母是依序循环出现的。举个例子： 
//
// 
// 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a' 
// 
//
// 
//
// 示例 1： 
//
// 
//输入: letters = ["c", "f", "j"]，target = "a"
//输出: "c"
// 
//
// 示例 2: 
//
// 
//输入: letters = ["c","f","j"], target = "c"
//输出: "f"
// 
//
// 示例 3: 
//
// 
//输入: letters = ["c","f","j"], target = "d"
//输出: "f"
// 
//
// 
//
// 提示： 
//
// 
// 2 <= letters.length <= 10⁴ 
// letters[i] 是一个小写字母 
// letters 按非递减顺序排序 
// letters 最少包含两个不同的字母 
// target 是一个小写字母 
// 
// Related Topics 数组 二分查找 👍 219 👎 0

package leetcode.editor.cn;
public class P744FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        P744FindSmallestLetterGreaterThanTarget.Solution solution = new P744FindSmallestLetterGreaterThanTarget().new Solution();

        System.out.println("Hello world " + solution.nextGreatestLetter(new char[]{'a','b','z'}, 'z'));
        System.out.println("Hello world " + solution.nextGreatestLetter(new char[]{'b','c','f','j'}, 'b'));
        System.out.println("Hello world " + solution.nextGreatestLetter(new char[]{'c','f','j'}, 'a'));
        System.out.println("Hello world " + solution.nextGreatestLetter(new char[]{'c','f','j'}, 'c'));
        System.out.println("Hello world " + solution.nextGreatestLetter(new char[]{'c','f','j','m','n'}, 'g'));
        System.out.println("Hello world " + solution.nextGreatestLetter(new char[]{'e','e','e','k','q','q','q','v','v','y'}, 'f'));
        System.out.println("Hello world " + solution.nextGreatestLetter(new char[]{'e','e','e','k','q','q','q','v','v','y'}, 'q'));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        int l = 0;
        int r = letters.length;

        if (letters[r - 1] <= target) {
            return letters[0];
        }
        if (letters[0] > target) {
            return letters[0];
        }
        int mid = -1;
        while (l < r) {
            mid = l + (r - l) / 2;

            if (letters[mid] > target) {
                r = mid;
            }  else {
                l = mid + 1;
            }
        }

        return letters[mid] > target ? letters[mid] : letters[mid+1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}