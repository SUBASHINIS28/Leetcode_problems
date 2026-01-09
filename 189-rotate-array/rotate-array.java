class Solution {
    public void rotate(int[] nums, int k) 
    {
       k=k%nums.length;
       sort(nums,0,nums.length-1);
       sort(nums,0,k-1);
       sort(nums,k,nums.length-1);
    }

    private static void sort(int nums[],int a,int b)
    {
        while(a<b)
        {
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
        a++;
        b--;
        }
    }
}
    