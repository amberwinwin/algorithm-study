package hyy.demo.problem;

/**
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 * <p>
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 * <p>
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *  
 * <p>
 * 提示：
 * <p>
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 */
public class HammingWeight {
    public static int hammingWeight(int n) {
        if (n == Integer.MIN_VALUE) {
            return 1;
        }
        boolean flag = n >= 0 ? false : true;
        int[] arr = new int[32];
        n = Math.abs(n);
        int i = 31;
        int res = 0;
        while (n > 0) {
            arr[i] = n % 2;
            n /= 2;
            i--;
        }
        if (flag) {
            for (int j = 0; j < 32; j++) {
                arr[j] = arr[j] == 0 ? 1 : 0;
            }
            arr[31] += 1;
            for (int j = 31; j >= 0; j--) {
                if (arr[j] > 1) {
                    arr[j] -= 2;
                    if (j - 1 >= 0) {
                        arr[j - 1] += 1;
                    }
                }
            }
        }
        for (int j = 0; j < 32; j++) {
            res += arr[j];
        }
        return res;
    }

    public static void main(String[] args) {
        int n = -3;
        System.out.println(hammingWeight(n));
    }
}
