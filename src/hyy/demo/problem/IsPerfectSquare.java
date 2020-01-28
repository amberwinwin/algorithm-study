package hyy.demo.problem;

/**
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * <p>
 * 示例 1：
 * <p>
 * 输入：16
 * 输出：True
 * 示例 2：
 * <p>
 * 输入：14
 * 输出：False
 */
public class IsPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (num % mid == 0 && mid == num / mid) {
                return true;
            } else if (mid < num / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args){
        isPerfectSquare(2147483647);
    }
}
