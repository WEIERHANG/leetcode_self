package array;

import java.util.Scanner;

/**
 * 使用前缀和数组解决区间和问题
 * [a,b]
 * 前缀和公式 sum = p[b] - p[a - 1];
 *
 */
public class PreArrSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] preArr = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
            preArr[i] = sum;
        }
        while(sc.hasNextInt()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int res = (a == 0) ? preArr[b] : preArr[b] - preArr[a - 1];
            System.out.println(res);
        }
        sc.close();
    }
}
