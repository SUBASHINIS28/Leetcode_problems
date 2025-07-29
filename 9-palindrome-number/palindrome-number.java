class Solution {
    public boolean isPalindrome(int x)
    {
        int t=x;
        int rev=0;
        while(t>0)
        {
            int d=t%10;
            rev=rev*10+d;
            t=t/10;
        }
        return x==rev;
    }
}