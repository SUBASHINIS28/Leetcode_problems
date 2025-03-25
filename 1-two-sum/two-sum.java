class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            int sum=target-nums[i];
            if(map.containsKey(sum))
            {
                int arr[]={map.get(sum),i};
                return arr;
            }
            map.put(nums[i],i);
        }
        return null;
        
    }
}