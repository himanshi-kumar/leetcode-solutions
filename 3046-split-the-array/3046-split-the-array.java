class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int[] fq = new int[101];
        for(int i = 0 ;i<nums.length ;i++){
            fq[nums[i]]++;
            if(fq[nums[i]]>2){
                return false;
            }

        }
        return true;

        
    }
}