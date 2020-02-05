package hyy.demo.problem;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 *
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int[] table = new int[nums.length+1];
        for (int ele : nums){
            table[ele] += 1;
        }
        for (int i = 0;i<table.length;i++) {
            if (table[i] == 0){
                return i;
            }
        }
        return 0;
    }
}