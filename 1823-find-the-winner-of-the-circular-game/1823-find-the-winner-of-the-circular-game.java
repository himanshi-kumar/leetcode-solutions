
import java.util.*;

class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        // Add all friends to the queue
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {
            // Move the first k-1 friends to the back
            for (int i = 1; i < k; i++) {
                q.offer(q.poll());
            }

            // Remove the kth friend
            q.poll();
        }

        return q.peek();
    }
}
