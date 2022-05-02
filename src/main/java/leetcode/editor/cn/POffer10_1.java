package leetcode.editor.cn;

public class POffer10_1 {

    private long[] arr =new long[101];

    public int fib(int n) {
        arr[0] = 0;
        arr[1] = 1;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (arr[n-2] != 0) {
            if (arr[n-1] != 0) {
                arr[n] = arr[n-1]%1000000007 + arr[n-2]%1000000007;
                return (int) (arr[n]%1000000007);
            } else {
                arr[n] = fib(n-1)%1000000007 + arr[n-2]%1000000007;
                return (int) (arr[n]%1000000007);
            }
        }
        arr[n] = fib(n-1)%1000000007 + fib(n - 2)%1000000007;
        return (int) (arr[n]%1000000007);
    }
}
