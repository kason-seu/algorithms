package leetcode.editor.cn;

import java.util.*;

public class P387 {

    public static void main(String[] args) {
        String s = "aabb";
        P387 p = new P387();
        p.firstUniqChar3(s);
    }

    public int firstUniqChar(String s) {

        int[] letters = new int[26];
        Arrays.fill(letters, -1);

        for (int i = 0; i < s.length(); i++) {
            if (letters[s.charAt(i) - 'a'] == -1) {
                letters[s.charAt(i) - 'a'] = i;
            } else {
                letters[s.charAt(i) - 'a'] = -2; // 重复了
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (letters[s.charAt(i) - 'a'] != -2) {
                return i;
            }
        }


        return -1;

    }



    public int firstUniqChar2(String s) {

        Map<Character, Integer> charsIndexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (charsIndexMap.containsKey(s.charAt(i))) {
                charsIndexMap.put(s.charAt(i), -1);
            } else {
                charsIndexMap.put(s.charAt(i), i);
            }
        }

        // 找到第一个不重复字符的索引.
        int ans = -1;
        for (int i : charsIndexMap.values()) {
            if (ans != -1) {
                ans =Math.min(ans, i);
            } else {
                ans = i;
            }
        }


        return ans;

    }

    public int firstUniqChar3(String s) {

        int[] letters = new int[26];
        Arrays.fill(letters, -1);

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (letters[s.charAt(i) - 'a'] == -1) {
                letters[s.charAt(i) - 'a'] = i;
                // 存储的是索引位置
                queue.addLast(i);
            } else {
                letters[s.charAt(i) - 'a'] = -2; // 重复了
                // 延迟删除
                while (!queue.isEmpty() && letters[s.charAt(queue.peek())-'a'] == -2) {
                 queue.pop();
                }
            }
        }


        return !queue.isEmpty() ? queue.pop() : -1;
    }

}
