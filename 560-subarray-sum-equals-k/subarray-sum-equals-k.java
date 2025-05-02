class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0, sum = 0;
        map.put(0, 1); // base case

        for (int num : nums) {
            sum += num;
            // if (sum - k) exists, it means we found a subarray
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            // update the prefix sum frequency
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
        
}
