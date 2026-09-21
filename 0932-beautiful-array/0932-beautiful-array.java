class Solution {
    public int[] beautifulArray(int n) {

        List<Integer> list = new ArrayList<>();
        list.add(1);

        while (list.size() < n) {

            List<Integer> next = new ArrayList<>();

            // Generate odd numbers
            for (int x : list) {
                int val = 2 * x - 1;

                if (val <= n) {
                    next.add(val);
                }
            }

            // Generate even numbers
            for (int x : list) {
                int val = 2 * x;

                if (val <= n) {
                    next.add(val);
                }
            }

            list = next;
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}