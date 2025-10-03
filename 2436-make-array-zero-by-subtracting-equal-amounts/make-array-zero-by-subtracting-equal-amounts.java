class Solution {
    public int minimumOperations(int[] nums) 
    {
        HashSet<Integer> operations = new HashSet<>();
        for(int num:nums)
        {
            if(num>0)
            {
                operations.add(num);
            }
        }
        return operations.size();
    }
}