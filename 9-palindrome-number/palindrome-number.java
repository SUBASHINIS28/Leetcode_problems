class Solution {
    public boolean isPalindrome(int x) {
        int m = x;
        int digit,rev = 0;
        if(x<0)
        {
            return false;
        }
        while(x!=0){
            digit=x%10;
            rev = (rev*10)+digit;
            x=x/10;
        }
        if(rev==m)
        {
         return true;
        }
        else
        {
         return false;
        }
    }
}