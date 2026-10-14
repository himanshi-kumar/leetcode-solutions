import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a min heap based on frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> freq.get(a) - freq.get(b)
        );

        // Step 3: Keep only the k most frequent elements
        for (int num : freq.keySet()) {
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Store the answer
        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}
