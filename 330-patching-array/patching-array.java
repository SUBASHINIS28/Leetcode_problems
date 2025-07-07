class Solution {
    public int minPatches(int[] nums, int n) 
    {
      long miss = 1;
      int i=0,patch=0;
      while(miss<=n)  
      {
        if(i<nums.length&&nums[i]<=miss)
        {
            miss+=nums[i];
            i++;
        }
        else
        {
            patch++;
            miss=2*miss;
        }
      }
      return patch;
    }
}