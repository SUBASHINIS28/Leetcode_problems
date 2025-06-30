class Solution {
    public int firstMissingPositive(int[] nums) 
    {
        int i = 0;
        while(i<nums.length)
        {
            int curr = nums[i]-1;
            if(curr>=0 && curr<nums.length && nums[i] != nums[curr])
            {
                swap(nums,i,curr);
            }
            else
            {
                i++;
            }
        }
        for(int j=0;j<nums.length;j++)
        {
            if(nums[j] !=j+1)
            {
                return j+1;
            }
        }
        return nums.length+1;

    }
    private static void swap(int[]arr,int a,int b)
    {
        int temp= arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}