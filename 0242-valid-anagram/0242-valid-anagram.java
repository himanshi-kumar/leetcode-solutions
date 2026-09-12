class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] i = s.toCharArray();
        char[] j = t.toCharArray();

        Arrays.sort(i);
        Arrays.sort(j);
        
        return Arrays.equals(i,j);
    }
}