class Solution {
    public int heightChecker(int[] heights) 
    {
        int num[] = heights.clone();
        Arrays.sort(num);
        int count=0;
        for(int i=0;i<heights.length;i++)
        {
            if(heights[i] != num[i])
            {
                count++;
            }
        }
        return count;
    }
}