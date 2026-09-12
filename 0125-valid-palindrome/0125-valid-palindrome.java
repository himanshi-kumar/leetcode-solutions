class Solution {
    public boolean isPalindrome(String s) {

        String st = "";

        // Clean the string
        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));

            if (Character.isLetterOrDigit(ch)) {
                st += ch;
            }
        }

        // Reverse
        String rev = "";

        for (int i = st.length() - 1; i >= 0; i--) {
            rev += st.charAt(i);
        }

        return st.equals(rev);
    }
}