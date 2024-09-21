package array;

public class ErFen {

    /**
     * 二分查找
     * 1. 初始化边界 l左边 = 0, r右边 = 数组长度减1
     * 2. while  l <= r 循环开始
     * 3. int mid = 左 + ((右 - 左) >> 1)
     * 4. 等于 返回mid   大了就更新右边r = 中间减一
     * 小了就更新左边 = mid + 1
     * 大了就减  小了就加
     * @param arr
     * @param v
     * @return
     */
    public static int erFen(int[] arr, int v){
        if(arr == null || arr.length == 0) return -1;
        int l = 0, r = arr.length - 1;
        while (l <= r){
            int mid = l + ((r - l) >> 1);
            if(arr[mid] == v) return mid;
            else if(arr[mid] > v) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] a = new int[]{1,4,5,6,7,8,9,10};
        int v = 80;
        System.out.println(erFen(a,v));

    }

}
