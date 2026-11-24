
class Solution {
    public int maxProduct(int[] nums) {

        int maxProduct = nums[0];
        int minProduct = nums[0];

        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int curr = nums[i];

            // Negative number can swap max and min
            if (curr < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            // Calculate new maximum and minimum
            maxProduct = Math.max(curr, maxProduct * curr);

            minProduct = Math.min(curr, minProduct * curr);

            // Update overall answer
            answer = Math.max(answer, maxProduct);
        }

        return answer;
    }
}
