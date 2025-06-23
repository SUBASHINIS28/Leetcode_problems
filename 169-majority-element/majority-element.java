class Solution {
    public int majorityElement(int[] nums) 
    {
        int count=0;
        int cand=0;
        for(int num:nums)
        {
            if(count==0)
            {
                cand=num;
            }
            count += (num==cand) ?1:-1;
        }
        return cand;
    }
}