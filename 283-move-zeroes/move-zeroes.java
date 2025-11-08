class Solution {
    public void moveZeroes(int[] nums) {
        int point=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[point]=nums[i];
                point++;
            }
        }
        for(int i=point; i<nums.length;i++){
            nums[i]=0;
        }
    }
}