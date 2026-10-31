
import java.util.*;

class Solution {

    public String reorganizeString(String s) {

        // Step 1: Count frequencies
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Step 2: Find maximum frequency
        int maxFreq = 0;

        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // Step 3: Check if rearrangement is possible
        if (maxFreq > (s.length() + 1) / 2) {
            return "";
        }

        // Step 4: Create Max Heap
        MaxHeap heap = new MaxHeap();

        for (int i = 0; i < 26; i++) {

            if (freq[i] > 0) {
                heap.insert(new Node((char)(i + 'a'), freq[i]));
            }
        }

        StringBuilder result = new StringBuilder();

        // Previously used character
        Node prev = null;

        // Step 5: Rearrange characters
        while (!heap.isEmpty()) {

            // Get most frequent character
            Node curr = heap.deleteMax();

            // Add character to result
            result.append(curr.ch);

            // Decrease frequency
            curr.freq--;

            // Reinsert previous character
            if (prev != null && prev.freq > 0) {
                heap.insert(prev);
            }

            // Current character becomes previous
            prev = curr;
        }

        return result.toString();
    }
}

// Node class
class Node {

    char ch;
    int freq;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

// Custom Max Heap
class MaxHeap {

    ArrayList<Node> heap = new ArrayList<>();

    void insert(Node node) {

        heap.add(node);

        heapifyUp(heap.size() - 1);
    }

    void heapifyUp(int idx) {

        while (idx > 0) {

            int parent = (idx - 1) / 2;

            if (heap.get(idx).freq > heap.get(parent).freq) {

                Collections.swap(heap, idx, parent);

                idx = parent;

            } else {
                break;
            }
        }
    }

    Node deleteMax() {

        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is Empty");
        }

        Node max = heap.get(0);

        Node last = heap.remove(heap.size() - 1);

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
                heap.get(left).freq > heap.get(largest).freq) {

                largest = left;
            }

            if (right < size &&
                heap.get(right).freq > heap.get(largest).freq) {

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

    boolean isEmpty() {
        return heap.isEmpty();
    }
}
