package leetcode200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LC_0003_longest_substring {
    /**
	 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
	 *
	 *  
	 *
	 * 示例 1:
	 *
	 * 输入: s = "abcabcbb"
	 * 输出: 3
	 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
	 * 示例 2:
	 *
	 * 输入: s = "bbbbb"
	 * 输出: 1
	 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
	 * 示例 3:
	 *
	 * 输入: s = "pwwkew"
	 * 输出: 3
	 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
	 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
	 *  
	 *
	 * 提示：
	 *
	 * 0 <= s.length <= 5 * 104
	 * s 由英文字母、数字、符号和空格组成
	 *
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public static int lengthOfLongestSubstring(String s) {
		//定义一个hashmap 来记录是否已经存在及标记子串的长度
		//用两个指针来设计一个滑动窗口
		HashMap<Character, Integer> HashMap = new HashMap<>();
		char[] chars = s.toCharArray();
		Integer left = 0;
		Integer right = 0;
		Integer max = 0;
		for (int i = 0; i <= chars.length-1; i++) {
			if (HashMap.containsKey(chars[i])) {
				left++;
			}else {
				HashMap.put(chars[i], 1);
			}
			right++;
			max = Math.max(max, right-left+1);

		}
		return max;
	}
	//所有字符串的排列组合
	public static ArrayList<String>  getParam(String remainder){
		int len = remainder.length();
		ArrayList<String> result = new ArrayList<String>();
		if(len==0){
			result.add("");
			return result;
		}
		for(int i=0;i<len;i++){
			String before = remainder.substring(0,i);
			String after = remainder.substring(i+1,len);
			ArrayList<String> param = getParam(before + after);
			for (String s :param){
				result.add(remainder.charAt(i)+s);
			}
		}
		return result;
	}
	public static String insertInside(String str,int leftIndex){
		String left = str.substring(0,leftIndex+1);
		String right = str.substring(leftIndex+1,str.length());
		return left + "()" +right;

	}
	//生成指定数量的括号对 比如输出3 生成()()() 、(())()、()(())、(()())、((()))
	public static void addParen(ArrayList<String> list,int leftRem,int rightRem,char[] str,int index){
		if(leftRem<0 || rightRem<leftRem) return;
		if(leftRem==0 && rightRem==0){
			list.add(String.copyValueOf(str));
		}else{
			str[index]='(';//左括号
			addParen(list,leftRem-1,rightRem,str,index+1);
			str[index]=')';//右括号
			addParen(list,leftRem,rightRem-1,str,index+1);
		}
	}
	public static ArrayList<String> generateParens(int count){
		char[] str = new char[count * 2];
		ArrayList<String> list = new ArrayList<String>();
		addParen(list,count,count,str,0);
		return list;
	}



	public static void main(String[] args) {
		String s= "pwwkew";
		String s1= "aab";

//		int ints2 = lengthOfLongestSubstring(s1);
//		System.out.println(ints2);
//		ArrayList<String> param = getParam("abc");
//		System.out.println(param);

//		String s2 = insertInside("()", 0);
//		System.out.println(s2);
		ArrayList<String> strings = generateParens(3);
		System.out.println(strings);


	}

}
