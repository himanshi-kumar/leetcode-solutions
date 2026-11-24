
import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int count = 0;

        // Initially, prefix sum 0 has occurred once
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {

            // Calculate running prefix sum
            sum += nums[i];

            // Check whether required previous prefix exists
            int remaining = sum - k;

            if (map.containsKey(remaining)) {
                count += map.get(remaining);
            }

            // Store/update frequency of current prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
