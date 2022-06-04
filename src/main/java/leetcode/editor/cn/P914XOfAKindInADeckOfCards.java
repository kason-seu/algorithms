/**
  * 题目Id：914
  * 题目：卡牌分组
  * 内容: //给定一副牌，每张牌上都写着一个整数。 
//
// 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组： 
//
// 
// 每组都有 X 张牌。 
// 组内所有的牌上都写着相同的整数。 
// 
//
// 仅当你可选的 X >= 2 时返回 true。 
//
// 
//
// 示例 1： 
//
// 
//输入：deck = [1,2,3,4,4,3,2,1]
//输出：true
//解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
// 
//
// 示例 2： 
//
// 
//输入：deck = [1,1,1,2,2,2,3,3]
//输出：false
//解释：没有满足要求的分组。
// 
//
// 
//提示： 
//
// 
// 1 <= deck.length <= 10⁴ 
// 0 <= deck[i] < 10⁴ 
// 
// Related Topics 数组 哈希表 数学 计数 数论 👍 256 👎 0
	
  * 日期：2022-05-14 12:39:16
*/
//给定一副牌，每张牌上都写着一个整数。 
//
// 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组： 
//
// 
// 每组都有 X 张牌。 
// 组内所有的牌上都写着相同的整数。 
// 
//
// 仅当你可选的 X >= 2 时返回 true。 
//
// 
//
// 示例 1： 
//
// 
//输入：deck = [1,2,3,4,4,3,2,1]
//输出：true
//解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
// 
//
// 示例 2： 
//
// 
//输入：deck = [1,1,1,2,2,2,3,3]
//输出：false
//解释：没有满足要求的分组。
// 
//
// 
//提示： 
//
// 
// 1 <= deck.length <= 10⁴ 
// 0 <= deck[i] < 10⁴ 
// 
// Related Topics 数组 哈希表 数学 计数 数论 👍 256 👎 0

package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class P914XOfAKindInADeckOfCards {
    public static void main(String[] args) {
        Solution solution = new P914XOfAKindInADeckOfCards().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {

            if (map.containsKey(i)) {
                Integer integer = map.get(i);
                map.put( i, integer + 1);
            } else {
                map.put( i, 1);
            }

        }

        Collection<Integer> values = map.values();
        List<Integer> collect = values.stream().collect(Collectors.toList());
        int X = collect.get(0);
        if (X < 2) {
            return false;
        }
        if (collect.size() == 1) {
            return true;
        }
        for (int i = 1; i< collect.size();i++) {

            if (X == collect.get(i)) {
                continue;
            } else {
                return false;
            }
        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}