
class Solution {
    public int minMoves(int[] nums) {

        // Find maximum element
        int max = nums[0];

        for (int num : nums) {
            max = Math.max(max, num);
        }

        // Calculate total moves
        int moves = 0;

        for (int num : nums) {
            moves += max - num;
        }

        return moves;
    }
}
