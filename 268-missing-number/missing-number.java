class Solution {
    public int missingNumber(int[] nums) {
        int sum=0,gum=0;
        for(int num:nums){
            sum+=num;
        }
        for(int i=0;i<=nums.length;i++){
            gum+=i;
        }
        return gum-sum;
    }
}