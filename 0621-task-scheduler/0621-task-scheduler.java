
import java.util.*;

class Solution {

    public int leastInterval(char[] tasks, int n) {

        // Step 1: Count task frequencies
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Step 2: Create Max Heap
        MaxHeap heap = new MaxHeap();

        for (int f : freq) {
            if (f > 0) {
                heap.insert(f);
            }
        }

        int time = 0;

        // Step 3: Process tasks in cycles
        while (heap.size() > 0) {

            ArrayList<Integer> temp = new ArrayList<>();

            int cycle = n + 1;
            int executed = 0;

            // Execute at most n+1 tasks
            while (cycle > 0 && heap.size() > 0) {

                int count = heap.deleteMax();

                count--;

                if (count > 0) {
                    temp.add(count);
                }

                executed++;
                cycle--;
            }

            // Put remaining frequencies back
            for (int count : temp) {
                heap.insert(count);
            }

            // Count intervals
            if (heap.size() == 0) {
                time += executed;
            } else {
                time += n + 1;
            }
        }

        return time;
    }
}

// Custom Max Heap
class MaxHeap {

    ArrayList<Integer> heap = new ArrayList<>();

    void insert(int val) {

        heap.add(val);

        heapifyUp(heap.size() - 1);
    }

    void heapifyUp(int idx) {

        while (idx > 0) {

            int parent = (idx - 1) / 2;

            if (heap.get(idx) > heap.get(parent)) {

                Collections.swap(heap, idx, parent);

                idx = parent;
            } else {
                break;
            }
        }
    }

    int deleteMax() {

        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is Empty");
        }

        int max = heap.get(0);

        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {

            heap.set(0, last);

            heapifyDown(0);
        }

        return max;
    }

    void heapifyDown(int idx) {

        int size = heap.size();

        while (true) {

            int largest = idx;

            int left = 2 * idx + 1;
            int right = 2 * idx + 2;

            if (left < size &&
                heap.get(left) > heap.get(largest)) {

                largest = left;
            }

            if (right < size &&
                heap.get(right) > heap.get(largest)) {

                largest = right;
            }

            if (largest != idx) {

                Collections.swap(heap, idx, largest);

                idx = largest;
            } else {
                break;
            }
        }
    }

    int size() {
        return heap.size();
    }
}
