class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        int n = s.length();
        int max = 0;
        int lastIndex[] = new int[128];
        for (int start = 0,end=0;end<n;end++)
        {
            char currentChar = s.charAt(end);
            start = Math.max(start,lastIndex[currentChar]);
            max  = Math.max(max,end- start +1);
            lastIndex[currentChar]=end+1;
        }
        return max;
    }
}