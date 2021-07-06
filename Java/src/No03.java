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
 * 思路：
 */

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
