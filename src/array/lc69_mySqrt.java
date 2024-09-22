package array;

/**
 * 69. x 的平方根pow
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 */
public class lc69_mySqrt {

    // 二分法
    public static int mySqrt(int x){
        if(x == 0) return 0;
        if(x == 1) return 1;
        int l = 1, r = x >> 1;
        while (l < r){
            int mid = l + ((r - l + 1) >> 1);
            if(mid > x/mid) r = mid - 1;
            else l = mid;
        }
        return l;
    }
    // 牛顿法
    public static double mySqrt2(int x){
        double x0 = x / 2.0, next;
        while (true){
            next = (x0 + x / x0) / 2.0;
            if(Math.abs(next - x0) < 1e-6) return next;
            x0 = next;
        }
    }
    public static void main(String[] args) {
        int a = 4;
        System.out.println(mySqrt(a));
        System.out.println(mySqrt2(a));


    }

}
