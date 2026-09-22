import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Opening brackets → push into stack
            if (ch == '(' || ch == '{' || ch == '[') {

                stack.push(ch);

            } 
            // Closing brackets
            else {

                // Nothing to match
                if (stack.isEmpty()) {
                    return false;
                }

                // Get the most recently opened bracket
                char top = stack.pop();

                // Check whether brackets match
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {

                    return false;
                }
            }
        }

        // If stack is empty, every bracket was matched
        return stack.isEmpty();
    }
}