package leetcode.editor.cn;

import java.util.Arrays;

public class POffer46 {

    public static void main(String[] args) {
        System.out.println(new POffer46().translateNum(12258));
        System.out.println(new POffer46().translateNum(25));
    }


    public int translateNum2(int num) {
        int[] cache = new int[(num + "").length()+1];
        Arrays.fill(cache, -1);
        return recur2(num+"", 0,cache);
    }

    public int translateNum(int num) {

        return dynamic(num+"");
    }


    private int dynamic(String numStr) {
        if (numStr.length() == 1) {
            return 1;
        }


        int pOne = 1;
        int qTwo = 1;
        int re = 0;
        for (int i = numStr.length() - 2; i >= 0; i--) {
            if (numStr.charAt(i) == '0') {
                re = pOne;
            } else {
                String substring = numStr.substring(i, i + 2);
                int digit = Integer.parseInt(substring);
                if (digit >= 10 && digit <= 25) {
                    re = pOne + qTwo;
                } else {
                    re = pOne;
                }
            }
            qTwo = pOne;
            pOne = re;
        }

        return re;

    }

    private int dynamic2(String numStr) {
        if (numStr.length() == 1) {
            return 1;
        }
        int[] cache = new int[numStr.length()+1];

        cache[numStr.length()] = 1;
        cache[numStr.length() - 1] = 1;
        for (int i = numStr.length() - 2; i >= 0; i--) {
            if (numStr.charAt(i) == '0') {
                cache[i] = cache[i+1];
            } else {
                String substring = numStr.substring(i, i + 2);
                int digit = Integer.parseInt(substring);
                if (digit >= 10 && digit <= 25) {
                    cache[i] = cache[i+1] + cache[i+2];
                } else {
                    cache[i] = cache[i+1];
                }
            }
        }

        return cache[0];

    }

    private int recur2(String numStr, int index, int[] cache) {
        if (index == numStr.length() - 1 || index == numStr.length()) {
            cache[index] = 1;
            return 1;
        }
        // 以当前index自身作为一个字符，其个数为:
        if (numStr.charAt(index) == '0') {
            if (cache[index+1] != -1) {
                cache[index] = cache[index+1];
                return cache[index];
            } else {
                cache[index+1] = recur2(numStr, index + 1, cache);
                cache[index] = cache[index+1];
                return cache[index];
            }
        } else {
            int num1 = 0;
            if (cache[index+1] != -1) {
                num1 = cache[index+1];
            } else {
                cache[index+1] = recur2(numStr, index + 1, cache);
                num1 = cache[index+1];
            }

            String substring = numStr.substring(index, index + 2);
            int digit = Integer.parseInt(substring);
            if (digit >= 10 && digit <= 25) {
                if (cache[index + 2] != -1) {
                    cache[index] = num1 + cache[index+2];
                    return cache[index];
                } else {
                    cache[index+2] = recur(numStr, index + 2);
                    cache[index] = num1 + cache[index+2];
                    return cache[index];
                }
            }
            cache[index] = num1;
            return num1;
        }

    }
    private int recur(String numStr, int index) {
        if (index == numStr.length() - 1 || index == numStr.length()) {
            return 1;
        }
        // 以当前index自身作为一个字符，其个数为:
        if (numStr.charAt(index) == '0') {
            return recur(numStr, index + 1);
        } else {
            int num1 = recur(numStr, index + 1);
            String substring = numStr.substring(index, index + 2);
            int digit = Integer.parseInt(substring);
            if (digit >= 10 && digit <= 25) {
                return num1 + recur(numStr, index + 2);
            }
            return num1;
        }

    }
}
