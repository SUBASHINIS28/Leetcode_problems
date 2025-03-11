class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int curr_ele=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
                curr_ele++;
                if(curr_ele>max)
                {
                    max=curr_ele;
                }
            }
            else curr_ele=0;
        }
        return max;
        
    }
}