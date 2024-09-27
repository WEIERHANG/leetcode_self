package hash;

import java.util.Arrays;
import java.util.Random;


/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词
 *字母异位词是 两个字符串是相同的字母 但是位置可以不一样
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class lc242_isAnagram {


    public static boolean sAnagram(String a, String b) {
        int[] arr = new int[26];
        for (int i = 0; i < a.length(); i++) arr[a.charAt(i) - 'a']++;
        for (int i = 0; i < b.length(); i++) arr[b.charAt(i) - 'a']--;
        for (int count : arr) {
            if (count != 0) return false;
        }
        return true;
    }

    // 辅助方法：通过排序来判断是否为字母异位词
    public static boolean anagramBySorting(String a, String b) {
        if (a.length() != b.length()) return false;
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    // 随机生成一个由小写字母组成的字符串
    public static String generateRandomString(int maxLength) {
        Random random = new Random();
        int length = random.nextInt(maxLength) + 1; // 随机长度（1到maxLength之间）
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char c = (char) (random.nextInt(26) + 'a'); // 随机生成一个小写字母
            sb.append(c);
        }
        return sb.toString();
    }

    // 对数器：验证两种方法的结果是否一致
    public static void runComparator(int testTimes, int maxLength) {
        Random random = new Random();
        for (int i = 0; i < testTimes; i++) {
            String a = generateRandomString(maxLength);
            String b = random.nextBoolean() ? shuffleString(a) : generateRandomString(maxLength); // 50%概率生成字母异位词
            boolean result1 = sAnagram(a, b); // 使用字符计数法
            boolean result2 = anagramBySorting(a, b); // 使用排序法
            if (result1 != result2) {
                System.out.println("Error found:");
                System.out.println("String a: " + a);
                System.out.println("String b: " + b);
                System.out.println("sAnagram result: " + result1);
                System.out.println("anagramBySorting result: " + result2);
                return; // 出现错误后立即停止测试
            }
        }
        System.out.println("全部通过!");
    }

    // 辅助方法：打乱字符串（用于生成字母异位词）
    public static String shuffleString(String s) {
        char[] arr = s.toCharArray();
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        // 运行对数器，测试1000次，字符串最大长度为20
        runComparator(1000, 20);
    }
}
