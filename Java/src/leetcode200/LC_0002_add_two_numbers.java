package leetcode200;

import class28.Problem_0019_RemoveNthNodeFromEndofList;

import java.util.Arrays;
import java.util.HashMap;

public class LC_0002_add_two_numbers {

	public static class ListNode {
		public int val;
		public ListNode next;
	}
    /**
	 * add-two-numbers
	 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
	 *
	 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
	 *
	 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
	 * 输入：l1 = [2,4,3], l2 = [5,6,4]
	 * 输出：[7,0,8]
	 * 解释：342 + 465 = 807.
	 * 示例 2：
	 *
	 * 输入：l1 = [0], l2 = [0]
	 * 输出：[0]
	 * 示例 3：
	 *
	 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
	 * 输出：[8,9,9,9,0,0,0,1]
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode.cn/problems/add-two-numbers
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

	}

    /**
     * 思路：
	 * 利用一个hashmap 来存储target-nums[i] 只要存在即找到了该值
	 * @param nums
     * @param target
     * @return
     */
	public  static int[] twoSum2(int[] nums, int target) {
		int[] res = {-1,-1};
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i=0;i<nums.length;i++){
			if(map.containsKey(target-nums[i])){
				res = new int[]{map.get(target - nums[i]),i };
				return res;
			}
			map.put(nums[i],i);

		}
		return  res;

	}

	public static void main(String[] args) {
		int[] nums = {1,3,4,5,5,6};
		int target = 4;
		int[] ints = twoSum(nums,target);
		int[] ints2 = twoSum2(nums,target);
		System.out.println(Arrays.toString(ints));
		System.out.println(Arrays.toString(ints2));

	}

}
