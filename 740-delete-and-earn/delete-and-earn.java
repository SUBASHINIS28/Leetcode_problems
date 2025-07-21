class Solution {
    public int deleteAndEarn(int[] nums) 
    {
        if(nums.length==1)
        {
            return nums[0];
        }
        if(nums.length==2)
        {
            if(Math.abs(nums[0]-nums[1])==1)
            {
                return Math.max(nums[0],nums[1]);
            }
            else
            {
                return nums[0]+nums[1];
            }
        }
        int max=nums[0];
        for(int num:nums){
            if(num>max){
                max=num;
            }
        }
        int arr[] =new int[max+1];
        for(int num:nums){
            arr[num]+=num;
        }
        int prevprev=arr[0];
        int prev=arr[1];
        for(int i=2;i<=max;i++){
            int curr=Math.max(arr[i]+prevprev,prev);
            prevprev=prev;
            prev=curr;
        }
        return prev;
    }
}