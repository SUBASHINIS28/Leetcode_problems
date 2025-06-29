class Solution {
    public int numDistinct(String a, String b) 
    {
        int m = a.length();
        int n = b.length();
        int d[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++) d[i][0] =1;
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(a.charAt(i-1) == b.charAt(j-1))
                {
                    d[i][j] = d[i-1][j-1]+d[i-1][j];
                }
                else
                {
                    d[i][j] = d[i-1][j];
                }
            }
        }
        return d[m][n];
    }
}