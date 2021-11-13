/**
  * 题目Id：307
  * 题目：区域和检索 - 数组可修改
  * 内容: //给你一个数组 nums ，请你完成两类查询，其中一类查询要求更新数组下标对应的值，另一类查询要求返回数组中某个范围内元素的总和。 
//
// 实现 NumArray 类： 
//
// 
// 
// 
// NumArray(int[] nums) 用整数数组 nums 初始化对象 
// void update(int index, int val) 将 nums[index] 的值更新为 val 
// int sumRange(int left, int right) 返回子数组 nums[left, right] 的总和（即，nums[left] + 
//nums[left + 1], ..., nums[right]） 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["NumArray", "sumRange", "update", "sumRange"]
//[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
//输出：
//[null, 9, null, 8]
//
//解释：
//NumArray numArray = new NumArray([1, 3, 5]);
//numArray.sumRange(0, 2); // 返回 9 ，sum([1,3,5]) = 9
//numArray.update(1, 2);   // nums = [1,2,5]
//numArray.sumRange(0, 2); // 返回 8 ，sum([1,2,5]) = 8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -100 <= nums[i] <= 100 
// 0 <= index < nums.length 
// -100 <= val <= 100 
// 0 <= left <= right < nums.length 
// 最多调用 3 * 10⁴ 次 update 和 sumRange 方法 
// 
// 
// 
// Related Topics 设计 树状数组 线段树 数组 👍 308 👎 0
	
  * 日期：2021-11-13 19:38:16
*/
//给你一个数组 nums ，请你完成两类查询，其中一类查询要求更新数组下标对应的值，另一类查询要求返回数组中某个范围内元素的总和。 
//
// 实现 NumArray 类： 
//
// 
// 
// 
// NumArray(int[] nums) 用整数数组 nums 初始化对象 
// void update(int index, int val) 将 nums[index] 的值更新为 val 
// int sumRange(int left, int right) 返回子数组 nums[left, right] 的总和（即，nums[left] + 
//nums[left + 1], ..., nums[right]） 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["NumArray", "sumRange", "update", "sumRange"]
//[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
//输出：
//[null, 9, null, 8]
//
//解释：
//NumArray numArray = new NumArray([1, 3, 5]);
//numArray.sumRange(0, 2); // 返回 9 ，sum([1,3,5]) = 9
//numArray.update(1, 2);   // nums = [1,2,5]
//numArray.sumRange(0, 2); // 返回 8 ，sum([1,2,5]) = 8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -100 <= nums[i] <= 100 
// 0 <= index < nums.length 
// -100 <= val <= 100 
// 0 <= left <= right < nums.length 
// 最多调用 3 * 10⁴ 次 update 和 sumRange 方法 
// 
// 
// 
// Related Topics 设计 树状数组 线段树 数组 👍 308 👎 0

package leetcode.editor.cn;

import data.structure.segmenttree.SegmentTree;

public class P307RangeSumQueryMutable {
    public static void main(String[] args) {
        NumArray solution = new P307RangeSumQueryMutable().new NumArray(new int[]{1,3,5});
        int i = solution.sumRange(0, 2);

        System.out.println(i);

        solution.update(1,2);
        i = solution.sumRange(0,2);
        System.out.println(i);

        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class NumArray {

        private SegmentTree<Integer> segmentTree;
    public NumArray(int[] nums) {

        Integer[] values = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            values[i] = nums[i];
        }
        segmentTree = new SegmentTree<>(values, Integer::sum);
    }
    
    public void update(int index, int val) {

        segmentTree.update(index, val);
    }
    
    public int sumRange(int left, int right) {
        return segmentTree.queryByRange(0, 0, segmentTree.getSize() - 1, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}