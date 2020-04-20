package LeetCode;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 */
public class LeetCode55 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
        System.out.println(canJump2(nums));
    }
    //找nums[i]=0 的情况，判断0之前的能否跳过0
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        int j;
        if(len==1)return true;
        for (int i = 0; i <len-1 ; i++) {   //找nums[i] =0
            if(nums[i] ==0){
                for (j = i-1; j >=0 ; j--) {
                    if(j +nums[j]>i) break;
                }
                if (j<0){
                    return false;
                }
            }
        }
        return true;
    }
    //遍历每个节点 计算能跳到的最远距离
    public static boolean canJump2(int[] nums){
        int can_reach=0;
        for (int i = 0; i <nums.length ; i++) {
            if(i>can_reach) return false;//如果跳点的距离大于最远距离  返回false
            can_reach = Math.max(can_reach,i+nums[i]);
        }
        return true;
    }
}
