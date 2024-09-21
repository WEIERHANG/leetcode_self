package array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 示例 1:
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 */
public class lc35_searchInsert {

    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = l + ((r - l) >> 1);
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return l;

    }



    }
