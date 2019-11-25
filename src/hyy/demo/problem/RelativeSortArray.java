package hyy.demo.problem;


/**
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同 arr2 中的每个元素都出现在 arr1 中 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。 
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6] 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000 0 <= arr1[i], arr2[i] <= 1000 arr2 中的元素 arr2[i] 各不相同 arr2
 * 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * @author hyy
 * @version V2.0, 2019/11/21
 * @copyright
 */
public class RelativeSortArray {

    public static int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int[] table = new int[1001];
        for (int i = 0; i < arr1.length; i++) {
            table[arr1[i]] += 1;
        }
        int pos = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (table[arr2[i]] > 0){
                arr1[pos++] = arr2[i];
                table[arr2[i]]--;
            }
        }
        for (int i = 0;i<table.length;i++){
            while (table[i] > 0){
                arr1[pos++] = i;
                table[i]--;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        relativeSortArray1(arr1, arr2);
        for (int ele : arr1) {
            System.out.print(ele);
        }
    }
}
