class Solution {
    public int singleNumber(int[] nums) {
        int unique=0;
        for(int suba:nums)
        {
            unique^=suba;
        }
    return unique;
        
    }
}