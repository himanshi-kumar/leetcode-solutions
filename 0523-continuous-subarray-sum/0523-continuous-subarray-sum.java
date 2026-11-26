
import java.util.*;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Remainder 0 exists before the array starts
        map.put(0, -1);

        long rem = 0;

        for (int i = 0; i < nums.length; i++) {

            // Calculate prefix sum remainder
            rem = (rem + nums[i]) % k;

            int r = (int) rem;

            // If remainder already exists
            if (map.containsKey(r)) {

                int prevIndex = map.get(r);

                // Subarray length must be at least 2
                if (i - prevIndex >= 2) {
                    return true;
                }

            } else {

                // Store only the first occurrence
                map.put(r, i);
            }
        }

        return false;
    }
}
