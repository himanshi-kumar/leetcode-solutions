class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums, new ArrayList<>());
        return ans;
    }

    private void backtrack(int index, int[] nums, List<Integer> curr) {

        ans.add(new ArrayList<>(curr));

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(i + 1, nums, curr);
            curr.remove(curr.size() - 1);
        }
    }
}