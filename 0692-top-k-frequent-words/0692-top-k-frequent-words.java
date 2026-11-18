
import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        // Step 1: Count frequencies
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Step 2: Create Min Heap
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> {
                if (!map.get(a).equals(map.get(b))) {
                    return Integer.compare(map.get(a), map.get(b));
                }
                return b.compareTo(a);
            }
        );

        // Step 3: Maintain only K elements
        for (String word : map.keySet()) {

            pq.offer(word);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Extract answers in correct order
        String[] result = new String[k];

        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }

        return Arrays.asList(result);
    }
}
