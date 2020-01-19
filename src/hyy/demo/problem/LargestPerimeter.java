package hyy.demo.problem;

import java.util.Arrays;

/**
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 *
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1,2] 输出：5 示例 2：
 *
 * 输入：[1,2,1] 输出：0 示例 3：
 *
 * 输入：[3,2,3,4] 输出：10 示例 4：
 *
 * 输入：[3,6,2,3] 输出：8  
 *
 * 提示：
 *
 * 3 <= A.length <= 10000 1 <= A[i] <= 10^6
 *
 * @author hyy
 * @version V2.0, 2020/1/15
 * @copyright
 */
public class LargestPerimeter {

    public int largestPerimeter(int[] A) {
        int l = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i++) {
            int tmp = handle(A[i], A[i + 1], A[i + 2]);
            if (tmp > l) {
                l = tmp;
            }
        }
        return l;
    }

    public int handle(int a, int b, int c) {
        if (a + b <= c) {
            return 0;
        }
        if (c - a >= b) {
            return 0;
        }
        return a + b + c;
    }
}
