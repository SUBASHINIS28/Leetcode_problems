class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[]result= new int[nums.length];
        int pt=0;
        int ni=1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                result[pt]=nums[i];
                pt=pt+2;
            }
            else
            {
                result[ni]=nums[i];
                ni=ni+2;
            }
        }
    return result ;
        
    }
}