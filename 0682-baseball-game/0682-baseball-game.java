import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {

            // Normal number
            if (op.equals("C")) {
                stack.pop();
            }

            else if (op.equals("D")) {
                int last = stack.peek();
                stack.push(2 * last);
            }

            else if (op.equals("+")) {
                int last = stack.pop();
                int secondLast = stack.peek();

                int newScore = last + secondLast;

                stack.push(last);
                stack.push(newScore);
            }

            else {
                // Convert String to integer
                stack.push(Integer.parseInt(op));
            }
        }

        int total = 0;

        while (!stack.isEmpty()) {
            total += stack.pop();
        }

        return total;
    }
}