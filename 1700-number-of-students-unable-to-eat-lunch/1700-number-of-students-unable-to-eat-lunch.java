import java.util.*;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> q = new LinkedList<>();

        // Put all students into the queue
        for (int student : students) {
            q.offer(student);
        }

        int rotations = 0;
        int sandwichIndex = 0;

        while (!q.isEmpty() && sandwichIndex < sandwiches.length) {

            // Student wants the sandwich
            if (q.peek() == sandwiches[sandwichIndex]) {

                q.poll();              // student leaves
                sandwichIndex++;       // next sandwich
                rotations = 0;         // reset counter

            } 
            else {

                // Student goes to the back
                q.offer(q.poll());
                rotations++;

                // Everyone has refused this sandwich
                if (rotations == q.size()) {
                    break;
                }
            }
        }

        return q.size();
    }
}