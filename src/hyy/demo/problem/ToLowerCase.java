package hyy.demo.problem;

/**
 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。

  

 示例 1：

 输入: "Hello"
 输出: "hello"
 * @author hyy
 * @version V2.0, 2019/11/25
 * @copyright
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        if (null == str || str.length() == 0){
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<str.length();i++){
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                sb.append((char)(str.charAt(i)+32));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println('H'-0);
    }
}
