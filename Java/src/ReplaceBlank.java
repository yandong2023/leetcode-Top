/**
 * 题目：替换空格
 * 请实现一个函数，把字符串中的每个空格替换成"%20"。
 * 例如输入"We are happy"，则输出"We%20are%20happy"
 *
 * 思路：有两种思路 一种是在原字符串上做替换一种是创建新的字符串，并替换原字符串 可以跟面试官确认一下，如果是在原字符串上替换
 * 替换，需要保证字符串后面有足够的空余内存。时间N的平方肯定是不行的
 *
 *  1.We are happy
 *  2.We%20are happy
 *  3.We%20are%20happay
 *
 *  时间复杂度为O(n)的解法
 *
 *  将替换由从前向后改成从后向前替换
 *  a.把第一个指针指向字符串的末尾，把第二个指针指向替换之后的字符串的末尾。
 *  b.依次复制字符串的内容，直至第一个指针碰到第一个空格
 *  c.把第一个空格替换成'20%'，把第一个指针向前移动1格，把第二个指针向前移动3格
 *  d. 依次向前复制字符串中的字符，直至碰到空格
 *  e.替换字符串中的倒数第二个宝利格，把第一个指针向前移动1格，把第二个指针向前移动3格
 */

public class ReplaceBlank {

    public static void main(String[] args) {
        String str = "We are happy";
        char[] charArray = str.toCharArray();
        int n = charArray.length;
//        System.out.println(change(charArray));
        System.out.println(replaceBlank(charArray,n));;
    }

    private static String replaceBlank(char string[],int length){
        if(string == null || length <0){
            return "";
        }
        //originalLength 为字符串string的实际长度
        int originalLength = 0;
        int numberOfBlank = 0;
        int i = 0;
        while (string[i] !='y'){
            ++originalLength;
            if(string[i] == ' '){
                ++numberOfBlank;
            }
            ++i;
        }
        // newLength 为把空格替换成'%20'之后的长度
        int newLength = originalLength + numberOfBlank * 2;
        if(newLength > length)
            return "";
        int indexOfOriginal = originalLength;
        int indexOfNew = newLength;
        while (indexOfOriginal >=0 && indexOfNew > indexOfOriginal){
            if(string[indexOfOriginal] == ' '){
                string[indexOfNew--] = '0';
                string[indexOfNew--] = '2';
                string[indexOfNew--] = '%';
            }else {
                string[indexOfNew--] = string[indexOfOriginal];
            }
            --indexOfOriginal;
        }
        return string.toString();

    }

    private static String change(char[] charArray) {
        //length为字符串数组string的总容量
        int n = charArray.length;
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                count++;
            }
        }
        if (count == 0) {
            return null;
        }
        char[] temp = new char[n + 2 * count];
        int j = n + 2 * count - 1;
        int i = n - 1;
        while (i >= 0) {
            if (charArray[i] == ' ') {
                temp[j] = '0';
                temp[j - 1] = '2';
                temp[j - 2] = '%';
                j = j - 3;
            } else {
                temp[j] = charArray[i];
                j--;
            }
            i--;
        }
        return new String(temp);
    }
}
