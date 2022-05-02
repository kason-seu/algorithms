package leetcode.editor.cn;

public class POffer10_2 {


    public int numWays(int n) {

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int nsub1 = 1; int nsub2 = 1;
        for (int i = 2; i <=n; i++) {
            int temp = (nsub1 + nsub2) % 1000000007;

            nsub1 = nsub2;
            nsub2 = temp;

        }

        return nsub2;

    }
}
