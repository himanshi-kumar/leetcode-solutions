
import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {

        // Create Max Heap
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones
        for (int stone : stones) {
            pq.add(stone);
        }

        // Continue until at most one stone remains
        while (pq.size() > 1) {

            // Remove two heaviest stones
            int y = pq.poll();
            int x = pq.poll();

            // If weights are different
            if (x != y) {
                pq.add(y - x);
            }
        }

        // Return remaining stone or 0
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
