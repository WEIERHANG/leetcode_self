package array;

/**
 * 使用二分法查找左右边界
 */
public class FInBorder {

    /**
     * 二分法找到左边界
     * @param arr
     * @param v
     * @return
     */
    public static int getL(int[] arr, int v){
        int l = 0, r = arr.length - 1, lBorder = -1;
        while (l <= r){
            int mid = l + ((r - l ) >> 1);
//            寻找左边界，就要在nums[middle] == target的时候更新right
            if(arr[mid] >= v){
                r = mid - 1;
                lBorder = r;
            }else {
                l = mid + 1;
            }
        }
        return lBorder;
    }

    // 找右边界  边界赋值在arr[mid] < v 里面
    public static int getR(int[] arr, int v){
        int l = 0, r = arr.length - 1 , rBorder = -1;
        while (l <= r){
            int mid = l + ((r - l) >> 1);
            if(arr[mid] > v) r = mid - 1;
            else{
                l = mid + 1;
                rBorder = l;
            }
        }
        return rBorder;
    }

}
