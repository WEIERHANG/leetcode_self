package array;


/**
 * 844. 比较含退格的字符串
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，
 * 如果两者相等，返回 true 。# 代表退格字符。
 *
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 *
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 *
 */
public class lc844_backspaceCompare {

    /**
     * 使用快慢指针法
     * 注意 要转成字符数组之后再操作
     * 快指针：寻找不等于#的值就插入 ；    慢指针：符合插入的位置
     * 当碰到#时，慢指针要回退一个，即插入的位置要往前退一个位置。
     * 求s，t字符串最后变成的字符串，返回最后的剩余符合条件的字符串，然后比较字符串。
     *
     */
    public static boolean backspaceCompare(String s, String t){
        String returnS = returnStr(s);
        String returnT = returnStr(t);
        return returnS.equals(returnT);
    }
    public static String returnStr(String str){
        int s = 0;
        char[] chars = str.toCharArray();
        for(int f = 0; f < str.length(); f++){
            if(chars[f] != '#') chars[s++] = chars[f];
            else {
                if(s > 0) s--;
            }
        }
        return new String(chars, 0, s);
    }


    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));  // 输出 true
        System.out.println(backspaceCompare("a##c", "#a#c"));  // 输出 true
        System.out.println(backspaceCompare("a#c", "b"));      // 输出 false

    }
}
