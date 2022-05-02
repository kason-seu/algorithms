package leetcode.editor.cn;

public class POffer58_1 {

    public static void main(String[] args) {
        System.out.println(new POffer58_1().reverseWords("  hello world!  "));
        System.out.println(new POffer58_1().reverseWords("he sky is blue"));
        System.out.println(new POffer58_1().reverseWords("I am a student. "));
        System.out.println(new POffer58_1().reverseWords(""));
    }

    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        int end = s.length() - 1;
        int start = -1;
        int pos = s.length() - 1;
        while (pos >= 0) {
            if (!(s.charAt(pos) == ' ')) {
                break;
            }
            pos--;
        }
        // 单词的终止符号
        end = pos;
        while (pos >= 0) {
            if (!(s.charAt(pos) == ' ') ) {
                pos--;
            } else {
                start = pos;
                sb.append(s.substring(start+1, end+1));
                // 找到不为空的那个pos
                while (pos >= 0) {
                    if (!(s.charAt(pos) == ' ')) {
                        break;
                    }
                    pos--;
                }
                if (pos >= 0) {
                    sb.append(" ");
                }
                end = pos;
            }
        }
        if (end >= 0 && pos == -1) {
            sb.append(s.substring(0, end+1));
        }
        return sb.toString();
    }
}
