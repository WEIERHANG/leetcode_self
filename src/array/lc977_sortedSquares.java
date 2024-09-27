package array;


/**
 * 977. 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方
 * 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 双指针思路
 * 1. 定义两个指针，分别指向原数组的头部（l）和尾部（r）。
 * 2. 定义一个结果数组 res，并且定义一个指针 k，指向结果数组的尾部。
 * 3. 比较原数组头部和尾部元素的平方。如果头部元素的平方小于尾部元素的平方，则将尾部元素的平方放入结果数组的尾部，同时将尾部指针 r 向前移动，并将结果数组的指针 k 向前移动。
 * 4. 否则，将头部元素的平方放入结果数组的尾部，然后将头部指针 l 向后移动，结果数组的指针 k 同样向前移动。
 * 5. 最后返回结果数组 res。
 */
public class lc977_sortedSquares {

    public static int[] sortedSquares(int[] arr) {
        int l = 0, r = arr.length - 1, k = arr.length - 1;
        int[] res = new int[arr.length];
        while(l <= r){
            if(arr[l] * arr[l] < arr[r] * arr[r]){
                res[k] = arr[r] * arr[r];
                k--;
                r--;
            }
            else{
                res[k] = arr[l] * arr[l];
                k--;
                l++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] a = {-4,-1,0,3,10};
        for(int i = 0; i < a.length; i++) System.out.print(" "+ a[i]);
        System.out.println();
        int[] res = sortedSquares(a);
        for(int i = 0; i < res.length; i++) System.out.print(" "+ res[i]);

    }

}
