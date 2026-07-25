class Solution {
    public boolean isPalindrome(int x) {
        int p = x;
        int rev = 0;
        while(x>0){
            int d = x%10;
            rev = rev*10+d;
            x=x/10;
        }
        if(rev==p){
            return true;
        }
        return false;
    }
}