package hyy.demo.problem;

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2] 输出: 210
 *
 * 示例 2:
 *
 * 输入: [3,30,34,5,9] 输出: 9534330 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。 输入: [121,12]
 *
 * @author hyy
 * @version V2.0, 2019/11/27
 * @copyright
 */
public class LargestNumber {

    public static String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0;i<nums.length;i++){
            arr[i] = String.valueOf(nums[i]);
        }
        sort(arr,0,arr.length-1);
        if (arr[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
    public static void sort(String[] arr,int left, int right){
        if (left >= right){
            return;
        }
        int i = left;
        int j = right;
        String key = arr[left];
        while (i<j){
            if (help(arr[j],key)){
                if (help(key,arr[i])){
                    String tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }else{
                    i++;
                }
            }else{
                j--;
            }
        }
        arr[left] = arr[i];
        arr[i] = key;
        sort(arr,left,i-1);
        sort(arr,i+1,right);
    }
    public static boolean help(String x,String y){
        if (x.equals(y)){
            return false;
        }
        if (x.equals("0")){
            return false;
        }
        if (y.equals("0")){
            return true;
        }
        String tmp1 = x+y;
        String tmp2 = y+x;
        for (int i = 0; i < tmp1.length(); i++) {
            if (tmp1.charAt(i) > tmp2.charAt(i)){
                return true;
            }
            if (tmp1.charAt(i) < tmp2.charAt(i)){
                return false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,4,7,2,5,8,0,3,6,9};

        System.out.println(largestNumber(nums));
    }
}



