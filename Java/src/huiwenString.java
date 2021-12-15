/**
 * 题目：验证回文字符串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 2 * 105
 * 字符串 s 由 ASCII 字符组成
 *
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/2020-top-interview-questions/xoktgm/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution {
    public boolean isPalindrome(String s) {
        //只保留字母和数字 将大写转为小写 有几种方法：双指针、栈、递归 这里用双指针实现
        //当遍历到一半 一直不相等就直接false
        int left =0;
        int right = s.length()-1;
        while(left<right){
            char c = Character.toLowerCase(s.charAt(left));
            char d = Character.toLowerCase(s.charAt(right));

            if(!Character.isLetterOrDigit(c)){
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(d)){
                right--;
                continue;
            }
            left++;
            right--;
            if(c!=d){
                return false;
            }
        }
        return true;


    }

}