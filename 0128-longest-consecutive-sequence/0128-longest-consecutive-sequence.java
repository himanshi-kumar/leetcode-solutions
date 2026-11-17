
class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Step 1: Add all numbers to HashSet
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Step 2: Find starting points
        for (int num : set) {

            if (!set.contains(num - 1)) {

                int count = 1;
                int current = num;

                // Step 3: Count consecutive numbers
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                // Step 4: Update maximum length
                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
