package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class POffer50 {
    public char firstUniqChar(String s) {

        int[] charPreq = new int[26];

        Arrays.fill(charPreq, -1 );

        Deque<Integer> deque = new ArrayDeque<>();


        for (int i = 0; i < s.length(); i++) {
            if (charPreq[s.charAt(i) - 'a'] == -1) {
                // 第一次出现，记录他的索引
                charPreq[s.charAt(i) - 'a'] = i;
                deque.add(i);
            } else { // 重复出现了，将它的值更新为-2
                charPreq[s.charAt(i) - 'a'] = -2;
                while (!deque.isEmpty() && charPreq[s.charAt(deque.peek()) - 'a'] == -2) {
                    deque.pop();
                }
            }
        }

        return deque.isEmpty() ? ' ' : s.charAt(deque.pop());


    }
}
