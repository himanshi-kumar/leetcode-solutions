import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ans = new ArrayList<>();

        int n = strs.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {

            if (visited[i])
                continue;

            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;

            for (int j = i + 1; j < n; j++) {

                if (!visited[j] && isAnagram(strs[i], strs[j])) {

                    group.add(strs[j]);
                    visited[j] = true;
                }
            }

            ans.add(group);
        }

        return ans;
    }

    // Function to check if two strings are anagrams
    public boolean isAnagram(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}