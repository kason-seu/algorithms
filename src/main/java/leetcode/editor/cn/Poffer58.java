package leetcode.editor.cn;

public class Poffer58 {

    public String reverseLeftWords(String s, int n) {

        return s.substring(n) + s.substring(0,n);
    }
}
