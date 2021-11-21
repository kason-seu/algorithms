package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 字符串的全部子序列， 重复和不重复的子序列
 */
public class SubSequence {


    public static void main(String[] args) {
        String s = "abc";

        List<String> subList = new ArrayList<>();
        subSequence(s.toCharArray(), 0, subList, "");
        System.out.println(subList);
    }


    /**
     *
     * @param strs 原始字符串
     * @param index 该到哪个位置进行选择，要还是不要
     * @param subList 已经走到了最后了，使用List记录所有沿途的路径
     * @param path 沿途的路径
     */
    static void subSequence(char[] strs, int index, List<String> subList, String path) {

        if (index == strs.length) {
            subList.add(path);
            return;
        }

        // 选择该index点的字符
        String yes =  path + strs[index] ;
        subSequence(strs, index + 1, subList, yes);

        // 不选择该index点的字符
        String no = path;

        subSequence(strs, index+1, subList, no);
    }


    static void subSequenceNoRepeat(char[] strs, int index, Set<String> subList, String path) {

        if (index == strs.length) {
            subList.add(path);
            return;
        }

        // 选择该index点的字符
        String yes =  path + strs[index] ;
        subSequenceNoRepeat(strs, index + 1, subList, yes);

        // 不选择该index点的字符
        String no = path;

        subSequenceNoRepeat(strs, index+1, subList, no);
    }
}
