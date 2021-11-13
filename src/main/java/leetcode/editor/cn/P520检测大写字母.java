package leetcode.editor.cn;

import java.nio.file.FileAlreadyExistsException;

public class P520检测大写字母 {


    class Solution {
        public boolean detectCapitalUse(String word) {

            int big = 0;
            int small = 0;
            boolean startWithBig = false;
            boolean startWithSmall = false;
            char c1 = word.charAt(0);
            if (c1 >= 'A' && c1 <= 'Z') {
                startWithBig = true;
                big++;
            } else if (c1 >= 'a' && c1 <= 'z') {
                startWithSmall = true;
                small++;
            }
            for (int i = 1; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c >= 'A' && c <= 'Z' ) {
                    if (startWithSmall) {
                        return false;
                    } else {
                        big++;
                    }
                }

                if (c >= 'a' && c <= 'z') {
                    small++;
                }
                if (startWithBig && big > 1 && small >= 1) {
                    return false;
                }

            }

            return true;


        }
    }
}
