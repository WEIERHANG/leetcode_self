package array;


/**
 * 26. 删除有序数组中的重复项
 * 给你一个 非严格递增排列 的数组 nums ，
 * 请你 原地 删除重复出现的元素，使每个元素 只出现一次
 * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * 然后返回 nums 中唯一元素的个数。
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 *
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 */
public class lc26_removeDuplicates {
    public static int removeDuplicates(int[] nums) {
        int s = 0;
        for(int f = 0; f < nums.length; f++){
            if(f == 0 || nums[f] != nums[f - 1]){
                nums[s++] = nums[f];
            }
        }
        return s;
    }

    public static void main(String[] args) {
        int[] a1 = {1,1,2};
        int[] a2 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(a1));
        System.out.println(removeDuplicates(a2));

    }



}
