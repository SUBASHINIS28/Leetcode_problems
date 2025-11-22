class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0, zerocount=0;
        int maxw=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                zerocount++;
            }
            while(zerocount>k){
                if(nums[left]==0){
                    zerocount--;
                }
                left++;
            }
            maxw=Math.max(maxw, right-left+1);
        }
        return maxw;
    }
}