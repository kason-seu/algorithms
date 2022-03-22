package leetcode.editor.algorithms.string;

import lombok.AllArgsConstructor;

import java.util.Arrays;

public class Manachor {


    public static void main(String[] args) {


        String s = "abacabad";
        //String s = "abckjkcbadfd";
        Manachor manachor = new Manachor();
        int manachor1 = manachor.manachor(manachor.addSharp(s));

        System.out.println("max " + (manachor1 * 2 + 1)/2);


    }

    @AllArgsConstructor
    class Pair{
        public int C;
        public int R;
    }

    private String addSharp(String s) {
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        return sb.toString();
    }
    private int manachor(String str) {

        // 回文半径
        int[] arr = new int[str.length()];
        int C = -1;
        int R = -1;

        for (int i = 0; i < str.length(); i++) {
            if (i >= R) {
                //暴力扩展
                Pair broad = broad2(arr, i,i, str);
                if (broad.R > R) {
                    R = broad.R;
                    C = broad.C;
                }
            } else {
                // 1)
                // 计算出i的对称点
                int ii = 2 * C - i;
                int iiRadius = arr[ii];
                int L = 2 * C - R;
                if (iiRadius > L) {
                    arr[i] = iiRadius; // 不更新R，因为R 不够右
                } else if (iiRadius == L) {
                    arr[i] = R - i; // 不更新R， R不变
                } else {
                    // ii的镜像超出了L，那么只能在暴力比较了
                    Pair broad = broad2(arr, i, R, str);
                   if (broad.R > R) {
                       R = broad.R;
                       C = broad.C;
                   }
                }
            }
        }
        return Arrays.stream(arr).max().getAsInt();
    }

    private Pair broad2(int[] arr, int i, int iR, String str) {

        int remove = 1;
        int currentBroad = iR - i;
        boolean flag = false;
        while (i - currentBroad- remove >= 0 && i +  currentBroad + remove < str.length()) {
            if (str.charAt(i-currentBroad-remove) == str.charAt(i + currentBroad + remove)) {
                flag = true;
                remove = remove + 1;
            } else {
                arr[i] = iR - i + remove - 1;
                return new Pair(i, iR + remove - 1);
            }
        }
        if (flag) {
            arr[i] = iR - i + remove - 1;
            return new Pair(i, iR + remove - 1);
        } else {
            return new Pair(i, i );
        }
    }

}
