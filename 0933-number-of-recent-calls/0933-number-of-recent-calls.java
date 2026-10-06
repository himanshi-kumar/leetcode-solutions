class RecentCounter {

    Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }

    public int ping(int t) {

        // Add current request
        q.offer(t);

        // Remove requests older than 3000 ms
        while (q.peek() < t - 3000) {
            q.poll();
        }

        // Number of recent requests
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */