import java.util.*;

class Solution {

    class Fenwick {
        int n;
        long[] tree;

        Fenwick(int n) {
            this.n = n;
            tree = new long[n + 1];
        }

        void update(int i, long val) {
            while (i <= n) {
                tree[i] += val;
                i += i & -i;
            }
        }

        long query(int i) {
            long sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }

        int kth(long k) {
            int idx = 0;
            int bit = Integer.highestOneBit(n);

            for (; bit > 0; bit >>= 1) {
                int next = idx + bit;

                if (next <= n && tree[next] < k) {
                    idx = next;
                    k -= tree[next];
                }
            }

            return idx + 1;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int m = 0;

        for (int v : sorted) {
            if (m == 0 || sorted[m - 1] != v) {
                sorted[m++] = v;
            }
        }

        Fenwick count = new Fenwick(m);
        Fenwick sum = new Fenwick(m);

        int[] id = new int[n];

        for (int i = 0; i < n; i++) {
            id[i] = Arrays.binarySearch(sorted, 0, m, nums[i]) + 1;
        }

        long[] cost = new long[n - x + 1];

        long totalSum = 0;

        for (int i = 0; i < x; i++) {
            count.update(id[i], 1);
            sum.update(id[i], nums[i]);
            totalSum += nums[i];
        }

        for (int i = 0; i <= n - x; i++) {

            int medianIndex = count.kth((x + 1L) / 2);
            long median = sorted[medianIndex - 1];

            long leftCount = count.query(medianIndex);
            long leftSum = sum.query(medianIndex);

            long rightCount = x - leftCount;
            long rightSum = totalSum - leftSum;

            cost[i] = median * leftCount - leftSum
                    + rightSum - median * rightCount;

            if (i < n - x) {
                count.update(id[i], -1);
                sum.update(id[i], -nums[i]);
                totalSum -= nums[i];

                count.update(id[i + x], 1);
                sum.update(id[i + x], nums[i + x]);
                totalSum += nums[i + x];
            }
        }

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= k; j++) {

                dp[i][j] = dp[i - 1][j];

                if (i >= x && dp[i - x][j - 1] != INF) {

                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - x][j - 1] + cost[i - x]
                    );
                }
            }
        }

        return dp[n][k];
    }
}