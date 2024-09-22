package array;

public class lc367_isPerfectSquare {

    /**
     * 二分查找方法判断是否为完全平方数
     * mid 被声明为 long，是为了防止溢出。
     * 因为在计算 mid * mid 时，如果 mid 是较大的数（例如接近 sqrt(num) 的值），
     * 那么 mid * mid 很可能超出 int 的范围（即超过 2^31 - 1）。
     */
    public boolean isPerfectSquareBinarySearch(int num) {
        int l = 1, r = num;
        while (l <= r) {
            long mid = l + ((r - l) >> 1);
            if (mid * mid == num) return true;
            else if (mid * mid > num) r = (int) mid - 1;
            else l = (int) mid + 1;
        }
        return false;
    }

    /**
     * 暴力解法，线性扫描判断是否为完全平方数
     */
    public boolean isPerfectSquareBruteForce(int num) {
        if (num < 1) return false;
        for (long i = 1; i * i <= num; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对数器，用两种方法测试并比较结果
     */
    public static void main(String[] args) {
        lc367_isPerfectSquare solution = new lc367_isPerfectSquare();
        int testTime = 10000; // 测试的次数
        int maxValue = 100000; // 测试的数字范围

        boolean isCorrect = true;
        for (int i = 1; i <= testTime; i++) {
            int num = (int) (Math.random() * maxValue + 1); // 随机生成测试数字
            boolean result1 = solution.isPerfectSquareBinarySearch(num);
            boolean result2 = solution.isPerfectSquareBruteForce(num);

            if (result1 != result2) {
                isCorrect = false;
                System.out.println("出错了！数字：" + num);
                System.out.println("二分查找结果: " + result1);
                System.out.println("暴力解法结果: " + result2);
                break;
            }
        }

        if (isCorrect) {
            System.out.println("两种方法的结果完全一致！");
        }
    }
}
