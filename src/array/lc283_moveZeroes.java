package array;


/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，
 * 同时保持非零元素的相对顺序。
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 */
public class lc283_moveZeroes {

    public static void moveZero(int[] arr){
        int s = 0;
        for(int f = 0; f < arr.length; f++){
            if(arr[f] != 0) arr[s++] = arr[f];
        }
        for(int i = s; i < arr.length; i++) arr[i] = 0;
    }

    public static void main(String[] args) {

        int[] a = {0,1,0,3,12};
        for(int i = 0; i < a.length; i++) System.out.print(" "+a[i]);
        System.out.println();
        moveZero(a);
        for(int i = 0; i < a.length; i++) System.out.print(" "+a[i]);
    }


}
