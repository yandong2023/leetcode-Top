/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *  
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/2020-top-interview-questions/xo341d/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

class Solution {
    public int maxSubArray(int[] nums) {
        //思路遍历数组
        // 1.假如全是负数，那就是找最大值即可，因为负数肯定越加越大。
        // 2.如果有正数，则肯定从正数开始计算和，不然前面有负值，和肯定变小了，所以从正数开始。
        // 3.当和小于零时，这个区间就告一段落了，然后从下一个正数重新开始计算(也就是又回到 2 了)。
        // 而 dp 也就体现在这个地方
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i] = Math.max(nums[i-1]+nums[i],nums[i]);
            max = Math.max(max,nums[i]);
        }
        return max;
    }
    public int maxSubArray(int[] nums) {
        /**
         * 首先sum是 和的意思， ans 是用来记录sum的最大值，因为sum会一直变化
         * 从开始遍历， 负数肯定是不会产生增益的，
         * 当sum < 0 时， 就已经没有再往后加的必要了，这个时候直接把下一个值拿过来赋值给sum
         * 当sum > 0 时， 就可以对后面的数产生增益，所以给他加上
         * 加完之后 比较一下sum和ans的大小， 取最大值
         * 如此循环
         */
        int ans = nums[0];
        //ans是最大值
        int sum = nums[0];
        for(int i=1; i<nums.length; i++){
            if(sum>0){
                sum += nums[i];
            }else{
                sum = nums[i];
            }
            ans = Math.max(sum,ans);

        }
        return ans;


    }
}