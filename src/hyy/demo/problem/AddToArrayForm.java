package hyy.demo.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,2,0,0], K = 34 输出：[1,2,3,4] 解释：1200 + 34 = 1234 示例 2：
 *
 * 输入：A = [2,7,4], K = 181 输出：[4,5,5] 解释：274 + 181 = 455 示例 3：
 *
 * 输入：A = [2,1,5], K = 806 输出：[1,0,2,1] 解释：215 + 806 = 1021 示例 4：
 *
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1 输出：[1,0,0,0,0,0,0,0,0,0,0] 解释：9999999999 + 1 = 10000000000  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000 0 <= A[i] <= 9 0 <= K <= 10000 如果 A.length > 1，那么 A[0] != 0
 *
 * @author hyy
 * @version V2.0, 2020/1/8
 * @copyright
 */
public class AddToArrayForm {

    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        while (K > 0) {
            list.add(K % 10);
            K /= 10;
        }
        int i = A.length - 1;
        int j = 0;
        int flag = 0;
        int size = list.size();
        Stack<Integer> stack = new Stack<>();
        while (i > -1 || j < size) {
            int a = i >= 0 ? 0 : A[i];
            int b = j >= size ? 0 : list.get(j);
            if (a + b + flag > 9) {
                stack.add(a + b + flag - 10);
                flag = 1;
            } else {
                stack.add(a + b + flag);
                flag = 0;
            }
            i--;
            j++;
        }
        list.clear();
        if (flag == 1){
            list.add(1);
        }
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        int[] x = new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        addToArrayForm(x, 1);
    }
}
