class Solution {
    public int longestMountain(int[] arr) 
    {
        int n = arr.length;
        if(n<3)
        {
            return 0;
        }
        int max = 0;
        for(int i=1;i<n-1;i++)
        {
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1])
            {
                int left = i;
                int right = i;
                while(left>0 && arr[left-1]< arr[left])
                {
                    left--;
                }
                while(right<n-1 && arr[right+1]<arr[right])
                {
                    right++;
                }
                int curr = right-left+1;
                max= Math.max(max,curr);
            }
        }
        return max;
    }
}