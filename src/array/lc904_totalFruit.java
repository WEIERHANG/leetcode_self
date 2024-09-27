package array;

import java.util.*;

/**
 * 904. 水果成篮
 *
 * 输入：fruits = [1,2,1]
 * 输出：3
 * 解释：可以采摘全部 3 棵树。
 *
 * 输入：fruits = [0,1,2,2]
 * 输出：3
 * 解释：可以采摘 [1,2,2] 这三棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
 *
 * 输入：fruits = [1,2,3,2,2]
 * 输出：4
 * 解释：可以采摘 [2,3,2,2] 这四棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
 */
public class lc904_totalFruit {

    /**
     *  1. 初始化变量 l  r max 和map
     *  2. for循环移动右边界 put进map里面   map存放 种类  和 最后出现的位置
     *  3. 如果 数的长度大于2 也就是长度超过2了
     *  移除最先出现的种类 并且把l左边界更新到移除的最后出现下标加1位置
     *  4. max求max和r-l+1之间的最大值并且返回
     */
    public static int totalFruit(int[] tree) {
        int l = 0, max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int r = 0; r < tree.length; r++){
            map.put(tree[r],r);
            if(map.size() > 2){
                int minIndex = tree.length - 1;
                for(int i : map.values()){
                    if(i < minIndex) minIndex = i;
                }
                map.remove(tree[minIndex]);
                l = minIndex + 1;
            }
            max = Math.max(max,r - l + 1);
        }
        return max;
    }



    public static void main(String[] args) {
        int[] a = {1,2,3,2,2};
        System.out.println(totalFruit(a));

    }
}
