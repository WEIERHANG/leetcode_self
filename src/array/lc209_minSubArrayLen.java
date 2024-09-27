package array;

import java.util.*;

/**
 * 209. 长度最小的子数组
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 */
public class lc209_minSubArrayLen {

    // 滑动窗口法
    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0, sum = 0, res = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    // 暴力解法，枚举所有可能的子数组
    public static int bruteForceMinSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    res = Math.min(res, j - i + 1);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    // 对数器，用于验证minSubArrayLen是否与暴力解法一致
    public static void testCorrectness() {
        Random random = new Random();
        int testCases = 100000;
        boolean allPass = true;

        for (int i = 0; i < testCases; i++) {
            int target = random.nextInt(50) + 1; // 随机生成target
            int length = random.nextInt(20) + 1; // 随机生成数组长度
            int[] nums = new int[length];
            for (int j = 0; j < length; j++) {
                nums[j] = random.nextInt(10) + 1; // 随机生成数组内容
            }

            int slidingWindowResult = minSubArrayLen(target, nums);
            int bruteForceResult = bruteForceMinSubArrayLen(target, nums);

            if (slidingWindowResult != bruteForceResult) {
                System.out.println("出错！");
                System.out.println("测试用例: target = " + target + ", nums = " + Arrays.toString(nums));
                System.out.println("滑动窗口法结果: " + slidingWindowResult);
                System.out.println("暴力解法结果: " + bruteForceResult);
                allPass = false;
                break;
            }
        }

        if (allPass) {
            System.out.println("所有测试通过！");
        }
    }

    public static void main(String[] args) {
        // 运行对数器
        testCorrectness();
    }
}
