package array;


/**
 *  lc27题,删除数组中的数
 *  因为数组是连续结构 是所以不能删除,只能覆盖掉
 *
 * 示例 : 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 */
public class lc27_delNumByArr {

    public static int removeElement(int[] nums, int val) {
        int s = 0;
        for(int f = 0; f < nums.length; f++){
            if(nums[f] != val){
                nums[s++] = nums[f];
            }
        }
        return s;
    }



    public static void main(String[] args) {
        int[] arr = {2,4,64,757,965,22};
        int n = 24;
        System.out.println(removeElement(arr,n));

    }
}
