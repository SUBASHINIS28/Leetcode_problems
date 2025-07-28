class Solution {
    public int missingNumber(int[] nums) 
    {
        int Xor = 0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            Xor ^= i ^ nums[i];
        }
        return n^Xor;
    }
}