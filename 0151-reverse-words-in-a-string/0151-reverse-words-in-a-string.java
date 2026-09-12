class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        String r = "";
        for(int i = words.length-1;i>=0;i--){
            r+=words[i];
            if(i!=0){
                r+=" ";
            }
        }
        return r;
    }
}