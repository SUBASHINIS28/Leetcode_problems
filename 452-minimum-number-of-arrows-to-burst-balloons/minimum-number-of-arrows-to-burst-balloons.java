class Solution {
    public int findMinArrowShots(int[][] points)
    {
        Arrays.sort(points,(a,b) -> Integer.compare(a[1],b[1]));
        int target = points[0][1];
        int arr = 1;
        for(int i=1;i<points.length;i++)
        {
            if(points[i][0] > target)
            {
                arr++;
                target=points[i][1];
            }
        }
        return arr;
    }
}