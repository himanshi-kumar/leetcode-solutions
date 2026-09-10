class Solution {

    public int[] sortArray(int[] nums) {
        mergesort(nums, 0, nums.length - 1);
        return nums;
    }

    void mergesort(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergesort(nums, left, mid);
        mergesort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    void merge(int[] nums, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int low = left;
        int high = mid + 1;
        int idx = 0;

        // Compare elements from both halves
        while (low <= mid && high <= right) {

            if (nums[low] <= nums[high]) {
                temp[idx] = nums[low];
                low++;
            } else {
                temp[idx] = nums[high];
                high++;
            }

            idx++;
        }

        // Remaining elements from left half
        while (low <= mid) {
            temp[idx] = nums[low];
            low++;
            idx++;
        }

        // Remaining elements from right half
        while (high <= right) {
            temp[idx] = nums[high];
            high++;
            idx++;
        }

        // Copy sorted elements back to nums
        for (int i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }
    }
}

