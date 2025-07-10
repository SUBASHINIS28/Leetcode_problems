class Solution {
    public int maxEnvelopes(int[][] envelopes) 
    {
        Arrays.sort(envelopes,(a,b) ->
        {
            if(a[0] == b[0])
            {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int [] dp = new int[envelopes.length];
        int len=0;

        for(int[] envelope : envelopes)
        {
            int height = envelope[1];
            int indx = Arrays.binarySearch(dp,0,len,height);
            if(indx<0)
            {
                indx = -(indx+1);
            }
            dp[indx] = height;
            if(indx==len)
            {
                len++;
            }
        }
        return len;
    }
}