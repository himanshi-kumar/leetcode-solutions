class Solution {
    public String removeStars(String s) {
        Stack<Character> st1 = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch=='*'){
                if(!st1.isEmpty()){
                    st1.pop();
                }
            }
            else{
                st1.push(ch);
            }
        }
        StringBuilder res = new StringBuilder();
        while(!st1.isEmpty()){
            res.append(st1.pop());
        }
        return res.reverse().toString();
        
        
    }
}