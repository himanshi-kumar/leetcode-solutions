class Solution {
    public int maxSubArray(int[] nums) {
        int curr = 0;
        int maxsum = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length ; i++){
            curr = Math.max(nums[i] , curr+nums[i]);
            maxsum = Math.max(maxsum , curr);

        }
        return maxsum;

        
    }
}