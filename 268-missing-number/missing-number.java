class Solution {
    public int missingNumber(int[] nums) {
        int sum=0,gum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        for(int j=0;j<=nums.length;j++){
            gum+=j;
        }
        return gum-sum;
    }
}