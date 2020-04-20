package LeetCode;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class leetCode1 {
    public static void main(String[] args) {
        int[] nums ={-3,4,3,90};
        int[] dump = twoSum(nums,0);
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] dump ={0,0};
        int x = 0;
        for (int i = 0; i <nums.length ; i++) {
            x = target - nums[i];
            for (int j = i+1; j <nums.length; j++) {
                if (x == nums[j]){
                    dump[0] = i;
                    dump[1] = j;
                    return dump;
                }
            }
        }
        return dump;
    }
}
