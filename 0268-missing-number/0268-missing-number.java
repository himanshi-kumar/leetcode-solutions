class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int exsum = n*(n+1)/2;
        int act = 0;
        for(int num:nums){
             act+=num;
        }
        return exsum-act;
    }
}