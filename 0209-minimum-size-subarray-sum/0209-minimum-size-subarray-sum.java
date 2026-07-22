class Solution {
    public int minSubArrayLen(int k, int[] arr) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < arr.length; right++) {

            sum += arr[right];

            while (sum >= k) {

                minLength = Math.min(minLength, right - left + 1);

                sum -= arr[left];
                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE)
            return 0;

        return minLength;
        
    }
}