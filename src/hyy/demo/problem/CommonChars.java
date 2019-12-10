package hyy.demo.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"] 输出：["e","l","l"] 示例 2：
 *
 * 输入：["cool","lock","cook"] 输出：["c","o"]  
 *
 * 提示：
 *
 * 1 <= A.length <= 100 1 <= A[i].length <= 100 A[i][j] 是小写字母
 *
 * @author hyy
 * @version V2.0, 2019/12/9
 * @copyright
 */
public class CommonChars {

    public static List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int[] table = new int[26];
        int[] tableHelp = new int[26];
        for (int i = 0; i < A[0].length(); i++) {
            table[A[0].charAt(i) - 'a'] += 1;
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                tableHelp[A[i].charAt(j) - 'a'] += 1;
            }
            for (int k = 0; k < 26; k++) {
                if (table[k] == 0 && tableHelp[k] == 0) {
                    continue;
                }
                if (table[k] == 0 || tableHelp[k] == 0) {
                    table[k] = 0;
                    tableHelp[k] = 0;
                    continue;
                }
                if (table[k] == tableHelp[k]){
                    tableHelp[k] = 0;
                    continue;
                }
                if (tableHelp[k] == 0){
                    table[k] = 0;
                    tableHelp[k] = 0;
                }else{
                    if (table[k] >= tableHelp[k]) {
                        table[k] = tableHelp[k];
                    }
                    tableHelp[k] = 0;
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (table[i] == 0) {
                continue;
            }
            for (int j = 0; j < table[i]; j++) {
                res.add(String.valueOf((char) ('a' + i)));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] str = new String[]{"bella", "label", "roller"};
        List<String> list = commonChars(str);
        for (String ele : list) {
            System.out.println(ele);
        }
    }
}
