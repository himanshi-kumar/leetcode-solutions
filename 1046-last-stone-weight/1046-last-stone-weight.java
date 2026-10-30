
import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {

        MaxHeap heap = new MaxHeap();

        // Insert all stones into Max Heap
        for (int stone : stones) {
            heap.insert(stone);
        }

        // Smash the two heaviest stones
        while (heap.size() > 1) {

            int y = heap.deleteMax(); // Heaviest
            int x = heap.deleteMax(); // Second heaviest

            if (x != y) {
                heap.insert(y - x);
            }
        }

        return heap.size() == 0 ? 0 : heap.deleteMax();
    }
}

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
