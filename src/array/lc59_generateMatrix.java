package array;

import javax.swing.plaf.IconUIResource;

/**
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，
 * 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 */
public class lc59_generateMatrix {

    public static int[][] generateMatrix(int n){
        int[][] arr = new int[n][n];
        int startX = 0, startY = 0;
        // offset代表矩阵的边界  [) 这样固定 每条变头开始 到尾巴前一个

        int offset = 1, count = 1, loop = 1,i,j;
        while(loop <= n / 2){
            // 上边 左到右
            for(j = startY; j < n - offset; j++) arr[startX][j] = count++;
            // 右边 上到下
            for(i = startX; i < n - offset; i++) arr[i][j] = count++;
            // 下边 右到左
            for( ; j > startY; j--) arr[i][j] = count++;
            // 左边 下到上
            for( ; i > startX; i--) arr[i][j] = count++;
            startX++;
            startY++;
            offset++;
            loop++;
        }
        if( n % 2 == 1) arr[startX][startY] = count;
        return arr;
    }



    public static void main(String[] args) {
        // 测试 n = 3
        int n = 3;
        int[][] matrix = generateMatrix(n);

        // 打印矩阵
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // 测试 n = 4
        n = 4;
        matrix = generateMatrix(n);

        // 打印矩阵
        System.out.println("螺旋矩阵 n = 4:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
