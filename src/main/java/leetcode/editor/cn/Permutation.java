package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 排列组合，去重和不去重的版本
 */
public class Permutation {


    public static void main(String[] args) {
        String input = "abc";
        char[] inputArray = input.toCharArray();
        List<String> result = new ArrayList<>();
        permutation(inputArray, 0, result);
        System.out.println(result);

        input = "aabc";
        char[] inputArrayRepeat = input.toCharArray();
        List<String> resultNoRepeat = new ArrayList<>();
        permutation(inputArrayRepeat, 0, resultNoRepeat);
        System.out.println(resultNoRepeat);
    }

    /**
     *
     * @param origin 原始字符串对应的char数组
     * @param index origin[0,..index-1] 已经确认好组合， orgin[i...] 从i开始的字符都可以在i的位置上
     * @param ans: 收集符合条件的结果
     */
    static void permutation(char[] origin, int index, List<String> ans) {

        if (index == origin.length) {
            ans.add(String.valueOf(origin));
        }
        // index以及之后的索引都可以尝试成为index的位置
        for( int j = index; j < origin.length; j++) {
            swap(origin, index, j);
            permutation(origin, index + 1, ans);
            swap(origin, j, index);
        }
    }

    private static void swap(char[] origin, int i, int j) {
        char temp = origin[i];
        origin[i]= origin[j];
        origin[j] = temp;

    }



    static void permutationNoREpeat(char[] origin, int index, List<String> ans) {

        if (index == origin.length) {
            ans.add(String.valueOf(origin));
        }
        // index以及之后的索引都可以尝试成为index的位置
        Set<Character> alreadyVisit = new HashSet<>();
        for( int j = index; j < origin.length; j++) {
            if (!alreadyVisit.contains(origin[index])) {
                alreadyVisit.add(origin[index]);
                swap(origin, index, j);
                permutationNoREpeat(origin, index + 1, ans);
                swap(origin, j, index);
            }
        }
    }

}
