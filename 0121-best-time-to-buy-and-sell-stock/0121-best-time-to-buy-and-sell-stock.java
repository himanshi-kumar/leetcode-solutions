class Solution {
    public int maxProfit(int[] nums) {
     
        int left = 0;
        int maxi= 0;
        

        for (int right = 1; right < nums.length; right++) {
            if(nums[right]<nums[left]){
                left = right;
            }
            else{

                maxi = Math.max(maxi,nums[right]-nums[left]);
            }
           
        }
        
        return maxi;
    }

    
}