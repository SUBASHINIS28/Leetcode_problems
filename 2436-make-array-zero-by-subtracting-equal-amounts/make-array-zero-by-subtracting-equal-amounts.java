class Solution {
    public int minimumOperations(int[] nums) 
    {
        HashSet<Integer> pos = new HashSet<>();
        for(int num:nums)
        {
            if(num>0)
            {
                pos.add(num);
            }
        }
        return pos.size();
    }
}