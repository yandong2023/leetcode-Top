/**
 * 题目：
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否函数该整数。
 *
 * 例如 下面的二维数组是每行、每列都递增排序。
 * 如果在这个数组中查找数字7，则返回true：
 * 如果查找数字5，由于数组不含有该数字，则返回false
 *
 * 1  2  8  9
 * 2  4  9  12
 * 4  7  10 13
 * 6  8  11 15
 *
 * 思路：在矩阵中加阴影，先将矩阵画出来，最简单的方法是遍历所有，但是时间复杂度为N的平方，因为这个数字是有规律的，
 * 从左向右递增，从上到下递增，所以直接取横坐标最大的数字与目标数字比较，如果比目标数字大，则向左移动，如果比目标数字大，则
 * 则向下移动 画阴影最直观。
 **/

public class No03 {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};

        System.out.println(search(arr, 7));
        System.out.println(isExist(arr, 5));
    }
    private static boolean isExist(int[][] arr,int value){
        int w = arr[0].length;
        int h = arr.length;
        int i = 0;
        int j = w-1;
        while (i <=h-1 && j>=0){
            if(arr[i][j] == value){
                return true;
            }
            if(arr[i][j] > value){
                j--;
            }else{
                i++;
            }
        }
        return  false;

    }


    private static boolean search(int[][] arr, int value) {

        int a = arr[0].length;
        int b = arr.length;
        int i = 0;
        int j = a - 1;

        while (i <= b - 1 && j >= 0) {
            if (arr[i][j] == value) {
                return true;
            }
            if (arr[i][j] > value) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
